package com.rest.study.board.travelboard.dto;

import com.rest.study.board.travelboard.entity.TravelBoard;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class TravelDto {

    private String travelMemberId;
    @NotBlank(message = "제목은 필수입니다.")
    private String travelTitle;
    @NotBlank(message = "내용은 필수입니다.")
    private String travelContent;
    @CreatedDate
    private LocalDateTime travelCreatedAt;

    public Travel toTravel(Travel travel) {
        travel.setTravelMemberId(travelMemberId);
        travel.setTravelTitle(travelTitle);
        travel.setTravelContent(travelContent);
        travel.setTravelCreatedAt(travelCreatedAt);
        return travel;
    }

    public Travel toTravel(){
        return Travel.builder()
                .travelMemberId(travelMemberId)
                .travelTitle(travelTitle)
                .travelContent(travelContent)
                .travelCreatedAt(travelCreatedAt)
                .build();
    }
}
