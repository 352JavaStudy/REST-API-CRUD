package com.rest.study.board.freeboard.controller;

import com.rest.study.board.freeboard.service.FreeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/free")
@Slf4j
public class FreeBoardController {

    @Autowired
    private FreeBoardService freeBoardService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(freeBoardService.findAll());
    }
}
