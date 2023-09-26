package com.rest.study.board.foodboard.controller;

import com.rest.study.board.foodboard.dto.FoodBoardDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodboard.service.FoodBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins ="http://localhost:8080")
@Slf4j
@RestController
@RequestMapping("/foodBoards")
// @Controller 모든 핸들러에 @ResponseBody 어노테이션 적용해줌
// @ResponseBody 핸들러에 반환된 자바 객체를 Response Body에 써줌
public class FoodBoardApiController {

    @Autowired
    private FoodBoardService foodBoardService;

    @GetMapping
    public ResponseEntity<List<FoodBoard>> findAll() {
        // HttpEntity 클래스를 상속받아 구현한 ResponseEntity 응답 데이터(헤더/바디)를 포함한 클래스
        List<FoodBoard> foodBoards = foodBoardService.findAll();
        return ResponseEntity.ok(foodBoards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodBoard> findById(@PathVariable Long id) {
        FoodBoard foodBoard = foodBoardService.findById(id);
        if(foodBoard == null)
                return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foodBoard);
    }


    @PostMapping
    public ResponseEntity<FoodBoard> createBoard(@Valid @RequestBody FoodBoardDto foodBoardDto, BindingResult bindingResult) {
        FoodBoard foodBoard = foodBoardDto.toFoodBoard();
        return ResponseEntity.ok(foodBoardService.save(foodBoard));
    }

}