package com.rest.study.board.foodimage.service;

import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodimage.entity.ImageAttachment;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    ImageAttachment uploadFile(MultipartFile images, FoodBoard foodBoard);
}
