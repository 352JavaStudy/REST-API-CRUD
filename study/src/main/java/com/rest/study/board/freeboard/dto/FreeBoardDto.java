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

    private String freeTitle;
    private String freeContent;
    private String freeMemberId;

    public FreeBoard toFreeBoardDto(FreeBoard freeBoard) {
                freeBoard.setFreeTitle(freeTitle);
                freeBoard.setFreeContent(freeContent);
                freeBoard.setFreeMemberId(freeMemberId);
                return freeBoard;
    }

    public void update(FreeBoardDto freeBoardDto) {
        this.freeTitle = freeBoardDto.getFreeTitle();
        this.freeContent = freeBoardDto.getFreeContent();
        this.freeMemberId = freeBoardDto.getFreeMemberId();
    }
}

