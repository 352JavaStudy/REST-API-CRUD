package com.rest.study.board.travelboard.controller;


import com.rest.study.board.travelboard.entity.TravelBoard;
import com.rest.study.board.travelboard.service.TravelBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "http://localhost:8080")
@RestController // @Controller인데 모든핸들러에 @ResponseBody어노테이션을 적용해준다.
@RequestMapping("/travel")
@Slf4j
public class TravelBoardController {

    @Autowired
    private TravelBoardService travelService;










}
