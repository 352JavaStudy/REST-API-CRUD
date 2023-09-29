package com.rest.study.board.freeboard.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.user.entity.User;
import lombok.Builder;
import lombok.Data;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Timestamp;

@Data
@Builder
public class FreeBoardReadDto {
    private Long freeId;
    private String userId;
    private String freeTitle;
    private String freeContent;
    private Timestamp freeCreatedAt;

    public static FreeBoardReadDto toDto(FreeBoard freeBoard) {
        User user = freeBoard.getUser();
        String userId = (user instanceof HibernateProxy) ? null : user.getUserId();
        return FreeBoardReadDto.builder()
                .freeId(freeBoard.getFreeId())
                .freeContent(freeBoard.getFreeContent())
                .freeTitle(freeBoard.getFreeTitle())
                .freeCreatedAt(freeBoard.getFreeCreatedAt())
                .userId(userId)
                .build();
    }

    public FreeBoard toFreeBoard() {
        FreeBoard freeBoard = new FreeBoard();
        freeBoard.setFreeTitle(this.freeTitle);
        freeBoard.setFreeContent(this.freeContent);
        freeBoard.setFreeCreatedAt(this.freeCreatedAt);
        return freeBoard;
    }
}