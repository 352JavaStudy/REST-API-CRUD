package com.rest.study.board.foodboard.service;

import com.rest.study.board.foodboard.dto.FoodBoardDto;
import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.user.entity.User;

import javax.validation.Valid;
import java.util.List;

public interface FoodBoardService {
    List<FoodBoard> findAll();
    FoodBoardReadDto findBoard(Long id);
    FoodBoard save(FoodBoard foodBoard);
    void deleteById(Long id);

    FoodBoardReadDto editBoard(Long id, FoodBoardDto foodBoardDto, User user);
}
