package com.rest.study.board.freeboard.entity;

import com.rest.study.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@SequenceGenerator(name = "SEQ_FREE_BOARD_ID", sequenceName = "SEQ_FREE_BOARD_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FREE_BOARD_ID")
    private Long freeId;

    @Column(nullable = false, length = 100)
    private String freeTitle;

    @Column(nullable = false)
    private String freeContent;

    @Column(nullable = false)
    private String freeMemberId;

    @CreationTimestamp
    private LocalDateTime freeCreatedAt;
}
