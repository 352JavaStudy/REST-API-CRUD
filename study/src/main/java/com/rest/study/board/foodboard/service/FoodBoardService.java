package com.rest.study.board.foodboard.service;

import com.rest.study.board.foodboard.entity.FoodBoard;

import java.util.List;

public interface FoodBoardService {
    List<FoodBoard> findAll();
    FoodBoard findById(Long id);
    FoodBoard save(FoodBoard foodBoard);
}
