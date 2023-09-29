package com.rest.study.board.foodboard.service;

import com.rest.study.board.foodboard.dto.FoodBoardDto;
import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodboard.repository.FoodBoardRepository;
import com.rest.study.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(rollbackFor = Exception.class)
@Service
public class FoodBoardServiceImpl implements FoodBoardService{

    @Autowired
    private FoodBoardRepository foodBoardRepository;

    @Override
    public List<FoodBoardReadDto> findBoards() {
        List<FoodBoard> boards = foodBoardRepository.findAllByOrderByFoodIdDesc();
        List<FoodBoardReadDto> boardDtoList = new ArrayList<>();
        boards.stream().forEach(i -> boardDtoList.add(FoodBoardReadDto.toDto(i)));
        return boardDtoList;
    }

    @Override
    public FoodBoardReadDto findBoard(Long id) {
        Optional<FoodBoard> optionalFoodBoard = foodBoardRepository.findById(id);
        if (optionalFoodBoard.isPresent()) {
            FoodBoard foodBoard = optionalFoodBoard.get();
            return FoodBoardReadDto.toDto(foodBoard);
        } else {
            throw new EntityNotFoundException("게시글이 존재하지 않습니다. : " + id);
        }
    }

    @Override
    public FoodBoard save(FoodBoard foodBoard) {
        return foodBoardRepository.save(foodBoard);
    }

    @Override
    public void deleteById(Long id) {
        foodBoardRepository.deleteById(id);
    }

    @Override
    public FoodBoardReadDto editBoard(Long id, FoodBoardDto foodBoardDto, User user) {
        Optional<FoodBoard> optionalFoodBoard = foodBoardRepository.findById(id);
        if (optionalFoodBoard.isPresent()) {
            FoodBoard foodBoard = optionalFoodBoard.get();
            foodBoardDto.toFoodBoard(foodBoard, user);
            foodBoardRepository.save(foodBoard);
            // 수정된 게시물을 바로 반환
            return FoodBoardReadDto.toDto(foodBoard);
        } else {
            throw new EntityNotFoundException("게시글이 존재하지 않습니다. : " + id);
        }
    }
}
