package com.rest.study.board.freeboard.dto;

import com.rest.study.board.freeboard.entity.FreeBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardDto {

    private Long freeId;
    private String freeTitle;
    private String freeContent;
    private String freeMemberId;
    private LocalDateTime freeCreatedAt;

    public FreeBoardDto toFreeBoard() {
        return new FreeBoardDto(
                this.getFreeId(),
                this.getFreeTitle(),
                this.getFreeContent(),
                this.getFreeMemberId(),
                this.getFreeCreatedAt());
    }

    public void update(FreeBoardDto freeBoardDto) {
        this.freeTitle = freeBoardDto.getFreeTitle();
        this.freeContent = freeBoardDto.getFreeContent();
        this.freeMemberId = freeBoardDto.getFreeMemberId();
    }
}

