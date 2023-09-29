package com.rest.study.board.image.entity;

import com.rest.study.board.foodboard.entity.FoodBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SequenceGenerator(name = "SEQ_IMAGE_ID", sequenceName = "SEQ_IMAGE_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ImageAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IMAGE_ID")
    private Long imageId;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String uniqueName;

    @Column(nullable = false)
    private Long imageFileSize;

    @ManyToOne
    @JoinColumn(name="FOOD_ID")
    private FoodBoard foodBoard;

}
