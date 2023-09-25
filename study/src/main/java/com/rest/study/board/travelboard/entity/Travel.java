package com.rest.study.board.travelboard.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "SEQ_MENU_ID", sequenceName ="SEQ_MENU_ID" , initialValue = 1, allocationSize = 1)
@DynamicUpdate // update시 변경된 필드만 쿼리문에 포함
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MENU_ID")
    private Long travelId;
    @Column(nullable = false) // Not Null
    private String travelMemberId;
    @Column(nullable = false) // Not Null
    private String travelTitle;
    @Column(nullable = false) // Not Null
    private String travelContent;
    @CreationTimestamp
    private LocalDateTime travelCreatedAt;

}
