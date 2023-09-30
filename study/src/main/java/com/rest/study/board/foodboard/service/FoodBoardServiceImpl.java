package com.rest.study.board.foodboard.service;

import com.rest.study.board.foodboard.dto.FoodBoardCreateDto;
import com.rest.study.board.foodboard.dto.FoodBoardReadDto;
import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodboard.repository.FoodBoardRepository;
import com.rest.study.board.foodimage.repository.ImageRepository;
import com.rest.study.board.foodimage.service.ImageService;
import com.rest.study.user.entity.User;
import com.rest.study.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(rollbackFor = Exception.class)
@Service
@Slf4j
public class FoodBoardServiceImpl implements FoodBoardService{

    @Autowired
    private FoodBoardRepository foodBoardRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

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
    public FoodBoardReadDto writeBoard(FoodBoardCreateDto foodBoardCreateDto) {
        User user = userService.findByUserId(foodBoardCreateDto.getFoodUserId());
        FoodBoard foodBoard = FoodBoard.builder()
                .foodContent(foodBoardCreateDto.getFoodContent())
                .foodTitle(foodBoardCreateDto.getFoodTitle())
                .user(user)
                .foodCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        foodBoard = foodBoardRepository.saveAndFlush(foodBoard);
        if(foodBoardCreateDto.getImages() != null) {
            imageService.uploadFile(foodBoardCreateDto.getImages(), foodBoard);
        }
        return FoodBoardReadDto.toDto(foodBoard);
    }

    @Override
    public void deleteById(Long id) {
        foodBoardRepository.deleteById(id);
    }

    @Override
    public FoodBoardReadDto editBoard(Long id, FoodBoardCreateDto foodBoardDto, User user) {
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
