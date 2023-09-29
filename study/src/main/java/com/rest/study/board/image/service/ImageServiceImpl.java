package com.rest.study.board.image.service;

import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.image.entity.Image;
import com.rest.study.board.image.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${image.upload.directory}")
    private String imageUploadDirectory; // 이미지 파일 저장 경로
    private Path fileDir;
    private final String TYPE_CSV = "text/csv";
    private String dir = "/tmp";

    @PostConstruct
    public void postConstruct() {
        fileDir = Paths.get(imageUploadDirectory).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileDir);
        } catch (IOException e) {
            log.error("이미지 업로드 디렉토리를 생성하지 못했습니다.: {}", e.getMessage());
        }
    }

    public Image uploadFile(MultipartFile file, FreeBoard freeBoard) throws IOException {
        // 파일 유형 검증
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image")) {
            throw new IllegalArgumentException("이미지 파일을 확인해주세요.");
        }

        String uploadFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String realName = UUID.randomUUID().toString() + "_" + uploadFileName;
        Path targetLocation = fileDir.resolve(realName);

        // 파일 저장
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
        }

        Image image = new Image();
        image.setOriginName(uploadFileName);
        image.setUniqueName(realName);
        image.setImageFileSize(file.getSize());

        image.setFreeBoard(freeBoard);

        return imageRepository.save(image);
    }
}
