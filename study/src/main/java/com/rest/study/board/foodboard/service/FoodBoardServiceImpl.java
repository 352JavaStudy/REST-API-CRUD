package com.rest.study.board.foodboard.service;

import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodboard.repository.FoodBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class FoodBoardServiceImpl implements FoodBoardService{

    @Autowired
    private FoodBoardRepository foodBoardRepository;

    @Override
    public List<FoodBoard> findAll() {
        return foodBoardRepository.findAllByOrderByFoodIdDesc();
    }

    @Override
    public FoodBoardReadDto findById(Long id) {
        return FoodBoardReadDto.toDto(foodBoardRepository.findById(id).orElse(null));
    }

    @Override
    public FoodBoard save(FoodBoard foodBoard) {
        return foodBoardRepository.save(foodBoard);
    }

    @Override
    public void deleteById(Long id) {
        foodBoardRepository.deleteById(id);
    }
}
