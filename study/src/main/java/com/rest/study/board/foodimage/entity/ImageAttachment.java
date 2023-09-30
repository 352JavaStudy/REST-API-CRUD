package com.rest.study.board.foodimage.entity;

import com.rest.study.board.foodboard.entity.FoodBoard;
import lombok.*;

import javax.persistence.*;

@SequenceGenerator(name = "SEQ_IMAGE_ID", sequenceName = "SEQ_IMAGE_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "foodBoard")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FOOD_ID")
    private FoodBoard foodBoard;

}
