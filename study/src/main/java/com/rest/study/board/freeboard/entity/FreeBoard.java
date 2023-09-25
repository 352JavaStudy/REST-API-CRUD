package com.rest.study.board.freeboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@SequenceGenerator(name = "SEQ_FREE_ID", sequenceName = "SEQ_FREE_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FREE_ID")
    private Long freeId;
    @Column(nullable = false)
    private String freeTitle;
    @Column(nullable = false)
    private String freeContent;
    @Column(nullable = false)
    private String freeMemberId;
    @CreationTimestamp
    private Date freeCreatedAt;
}
