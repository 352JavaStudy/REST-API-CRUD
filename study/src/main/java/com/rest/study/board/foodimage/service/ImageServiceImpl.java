package com.rest.study.board.foodimage.service;

import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodimage.entity.ImageAttachment;
import com.rest.study.board.foodimage.repository.ImageRepository;
import com.rest.study.common.controller.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${image.upload.directory}")
    private String imageUploadDir;

    private Path fileDir;

    private final String TYPE_CSV = "text/csv";

    @PostConstruct
    public void postConstruct() {
        fileDir = Paths.get(imageUploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileDir);
        } catch (IOException e) {
            log.error("에러 = {}", e.getMessage());
        }
    }

    @Override
    public ImageAttachment uploadFile(MultipartFile images, FoodBoard foodBoard) {
        String uniqueName = StringUtils.generateUniqueName(images.getOriginalFilename());
        Path targetLocation = fileDir.resolve(uniqueName);
        try(InputStream inputStream = images.getInputStream()) {
            Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageAttachment image = ImageAttachment.builder()
                .originName(images.getOriginalFilename())
                .uniqueName(uniqueName)
                .foodBoard(foodBoard)
                .imageFileSize(images.getSize())
                .build();
        return  imageRepository.save(image);
    }
}
