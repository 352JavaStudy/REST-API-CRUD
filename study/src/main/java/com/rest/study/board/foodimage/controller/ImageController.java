package com.rest.study.board.foodimage.controller;

import com.rest.study.board.foodimage.entity.ImageAttachment;
import com.rest.study.board.foodimage.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    List<ImageAttachment> images = new ArrayList<>();

}
