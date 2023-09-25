package com.rest.study.board.foodboard.entity;

import com.rest.study.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodBoard {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "SEQ_FOOD_BOARD_ID")
    private Long foodId; // null을 확인하기 위해서 참조형으로

    @ManyToOne
    @JoinColumn(name = "food_member_id")
    private Member member;

    @Column(nullable = false, length = 500)
    private String foodTitle;

    @Column(nullable = false, length = 4000)
    private String foodContent;

    @CreatedDate
    private Date foodCreatedAt;
}
