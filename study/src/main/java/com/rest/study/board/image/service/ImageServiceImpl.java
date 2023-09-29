package com.rest.study.board.image.service;

import com.rest.study.board.freeboard.repository.FreeBoardRepository;
import com.rest.study.board.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ImageServiceImpl {

    @Autowired
    private ImageRepository imageRepository;

}
