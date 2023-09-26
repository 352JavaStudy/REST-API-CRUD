package com.rest.study.board.freeboard.dto;

import com.rest.study.board.freeboard.entity.FreeBoard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public static FreeBoardDto freeBoardDto(FreeBoard freeBoard) {
        return new FreeBoardDto(
                freeBoard.getFreeId(),
                freeBoard.getFreeTitle(),
                freeBoard.getFreeContent(),
                freeBoard.getFreeMemberId(),
                freeBoard.getFreeCreatedAt());
    }
}

