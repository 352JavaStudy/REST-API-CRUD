package com.rest.study.board.travelboard.controller;

import com.rest.study.board.travelboard.service.TravelBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/travel")
@Slf4j
public class TravelBoardController {

    @Autowired
    private TravelBoardService travelBoardService;

    


}
