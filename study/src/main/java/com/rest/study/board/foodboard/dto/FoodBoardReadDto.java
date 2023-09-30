package com.rest.study.board.foodboard.dto;

import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.board.foodimage.entity.ImageAttachment;
import com.rest.study.user.entity.User;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class FoodBoardReadDto {
    private Long foodId;
    private String userId;
    private String foodTitle;
    private String foodContent;
    private Timestamp foodCreatedAt;
    private ImageAttachment images;

    public static FoodBoardReadDto toDto(FoodBoard foodBoard) {
        return FoodBoardReadDto.builder()
                .foodId(foodBoard.getFoodId())
                .foodContent(foodBoard.getFoodContent())
                .foodTitle(foodBoard.getFoodTitle())
                .foodCreatedAt(foodBoard.getFoodCreatedAt())
                .userId(foodBoard.getUser().getUserId())
                .build();
    }

    public FoodBoard toEntity(FoodBoardReadDto foodBoard, User user) {
        return FoodBoard.builder()
                .foodId(foodBoard.getFoodId())
                .foodContent(foodBoard.getFoodContent())
                .foodTitle(foodBoard.getFoodTitle())
                .foodCreatedAt(foodBoard.getFoodCreatedAt())
                .user(user)
                .build();
    }
}
