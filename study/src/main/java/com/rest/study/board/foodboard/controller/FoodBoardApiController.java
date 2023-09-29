package com.rest.study.board.foodboard.controller;

import com.rest.study.board.foodboard.dto.FoodBoardDto;
import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodboard.service.FoodBoardService;
import com.rest.study.user.entity.User;
import com.rest.study.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins ="http://localhost")
@Slf4j
@RestController
@RequestMapping("/api/foodboards")
// @Controller 모든 핸들러에 @ResponseBody 어노테이션 적용해줌
// @ResponseBody 핸들러에 반환된 자바 객체를 Response Body에 써줌
public class FoodBoardApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodBoardService foodBoardService;

    @GetMapping
    public ResponseEntity<List<FoodBoard>> getBoards() {
        // HttpEntity 클래스를 상속받아 구현한 ResponseEntity 응답 데이터(헤더/바디)를 포함한 클래스
        List<FoodBoard> boardList = foodBoardService.findAll();
        return ResponseEntity.ok(boardList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodBoardReadDto> getBoard(@PathVariable Long id) {
        FoodBoardReadDto foodBoard = foodBoardService.findById(id);
        if(foodBoard == null)
                return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foodBoard);
    }


    @PostMapping
    public ResponseEntity<FoodBoard> writeBoard(@Valid @RequestBody FoodBoardDto foodBoardDto, BindingResult bindingResult) {
        User user = userService.findByUserId(foodBoardDto.getFoodUserId());
        FoodBoard foodBoard = foodBoardDto.toFoodBoard(user);
        return ResponseEntity.ok(foodBoardService.save(foodBoard));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FoodBoard> updateBoard(@PathVariable Long id, @Valid @RequestBody FoodBoardDto foodBoardDto) {
        User user = userService.findByUserId(foodBoardDto.getFoodUserId());
//        FoodBoard board = foodBoardService.findById(id);
//        if(board == null)
//            return ResponseEntity.notFound().build();
//        foodBoardDto.toFoodBoard(board, user);
//        foodBoardService.save(board);
//        return ResponseEntity.ok(board);

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodBoard> deleteBoard(@PathVariable Long id) {
        foodBoardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
