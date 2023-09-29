package com.rest.study.board.foodboard.dto;

import com.rest.study.board.foodboard.entity.FoodBoard;
import com.rest.study.user.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class FoodBoardDto {

//    private User user;
    private String foodUserId;

    @NotBlank(message = "제목은 필수입니다.")
    private String foodTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String foodContent;

    private Timestamp foodCreatedAt;

    public FoodBoard toFoodBoard(User user) {
        return FoodBoard.builder()
                .foodContent(foodContent)
                .foodTitle(foodTitle)
                .user(user)
                .foodCreatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }

    public FoodBoard toFoodBoard(FoodBoard board, User user) {
        board.setFoodTitle(foodTitle);
        board.setFoodContent(foodContent);
        board.setUser(user);
        return board;
    }
}
