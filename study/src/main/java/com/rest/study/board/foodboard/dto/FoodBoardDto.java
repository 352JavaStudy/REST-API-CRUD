package com.rest.study.board.foodboard.dto;

import com.rest.study.board.foodboard.entity.FoodBoard;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class FoodBoardDto {

    private String foodMemberId;

    @NotBlank(message = "제목은 필수입니다.")
    private String foodTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String foodContent;

    private Timestamp foodCreatedAt;

    public FoodBoard toFoodBoard() {
        return FoodBoard.builder()
                .foodContent(foodContent)
                .foodTitle(foodTitle)
                .foodMemberId(foodMemberId)
                .foodCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
}
