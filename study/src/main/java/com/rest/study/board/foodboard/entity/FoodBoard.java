package com.rest.study.board.foodboard.entity;

import com.rest.study.member.entity.Member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class FoodBoard {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "SEQ_FOOD_BOARD_ID")
    private Long foodId; // null을 확인하기 위해서 참조형으로

    private String foodMemberId;

    @Column(nullable = false, length = 500)
    private String foodTitle;

    @Column(nullable = false, length = 4000)
    private String foodContent;

// TemporalType.TIMESTAMP : date + time 의 timestamp(datetime) 타입
//    @Column(nullable = false, columnDefinition = "date default systimestamp")
    @CreationTimestamp
    private Timestamp foodCreatedAt;
}
