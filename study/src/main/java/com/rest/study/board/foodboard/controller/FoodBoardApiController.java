package com.rest.study.board.foodboard.controller;

import com.rest.study.board.foodboard.dto.FoodBoardCreateDto;
import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodboard.service.FoodBoardService;
import com.rest.study.user.entity.User;
import com.rest.study.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FoodBoardReadDto>> getBoards() {
        return ResponseEntity.ok(foodBoardService.findBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodBoardReadDto> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(foodBoardService.findBoard(id));
    }

    @PostMapping
    public ResponseEntity<FoodBoard> writeBoard(@Valid @RequestBody FoodBoardCreateDto foodBoardDto, BindingResult bindingResult) {
        User user = userService.findByUserId(foodBoardDto.getFoodUserId());
        FoodBoard foodBoard = foodBoardDto.toFoodBoard(user);
        return ResponseEntity.ok(foodBoardService.save(foodBoard));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FoodBoardReadDto> editBoard(@PathVariable Long id, @Valid @RequestBody FoodBoardCreateDto foodBoardDto) {
        User user = userService.findByUserId(foodBoardDto.getFoodUserId());
        return ResponseEntity.ok(foodBoardService.editBoard(id, foodBoardDto, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodBoard> deleteBoard(@PathVariable Long id) {
        foodBoardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
