package com.rest.study.board.foodboard.controller;

import com.rest.study.board.foodboard.service.FoodBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodBoards")
// @Controller 모든 핸들러에 @ResponseBody 어노테이션 적용해줌
// @ResponseBody 핸들러에 반환된 자바 객체를 Response Body에 써줌
public class FoodBoardApiController {

    @Autowired
    private FoodBoardService foodBoardService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        // HttpEntity 클래스를 상속받아 구현한 ResponseEntity 응답 데이터(헤더/바디)를 포함한 클래스
        return ResponseEntity.ok(foodBoardService.findAll());
    }

}
