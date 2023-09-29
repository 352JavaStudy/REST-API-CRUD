package com.rest.study.board.image.service;

import com.rest.study.board.foodboard.dto.FoodBoardCreateDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.image.entity.ImageAttachment;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    ImageAttachment uploadFile(MultipartFile images, FoodBoard foodBoard);
}
