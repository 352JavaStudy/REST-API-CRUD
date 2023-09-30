package com.rest.study.board.foodimage.service;

import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodimage.entity.ImageAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    ImageAttachment uploadFile(MultipartFile file, FoodBoard foodBoard);
}
