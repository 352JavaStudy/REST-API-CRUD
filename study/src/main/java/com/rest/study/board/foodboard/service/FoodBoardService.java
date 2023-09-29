package com.rest.study.board.foodboard.service;

import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;

import java.util.List;

public interface FoodBoardService {
    List<FoodBoard> findAll();
    FoodBoardReadDto findById(Long id);
    FoodBoard save(FoodBoard foodBoard);
    void deleteById(Long id);
}
