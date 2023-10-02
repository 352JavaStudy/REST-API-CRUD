package com.rest.study.image.freeImage.service;

import com.rest.study.board.freeboard.entity.FreeBoard;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    Object uploadFile(MultipartFile file, FreeBoard freeBoard) throws IOException;
}
