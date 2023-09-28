package com.rest.study.board.freeboard.dto;

import com.rest.study.board.freeboard.entity.FreeBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardDto {

    private String freeMemberId;
    @NotBlank(message = "제목은 필수입니다.")
    private String freeTitle;
    @NotBlank(message = "내용은 필수입니다.")
    private String freeContent;

    public FreeBoard toFreeBoardDto(FreeBoard freeBoard) {
                freeBoard.setFreeTitle(freeTitle);
                freeBoard.setFreeContent(freeContent);
                freeBoard.setFreeMemberId(freeMemberId);
                return freeBoard;
    }

    public FreeBoard toFreeBoardDto() {
        return FreeBoard.builder()
                .freeMemberId(freeMemberId)
                .freeTitle(freeTitle)
                .freeContent(freeContent)
                .build();
    }
}

