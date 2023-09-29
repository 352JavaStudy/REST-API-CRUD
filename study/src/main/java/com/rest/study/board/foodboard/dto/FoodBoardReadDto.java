package com.rest.study.board.foodboard.dto;

import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.user.entity.User;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
public class FoodBoardReadDto {
    private Long foodId;
    private String userId;
    private String foodTitle;
    private String foodContent;
    private Timestamp foodCreatedAt;

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
