<<<<<<<< HEAD:study/src/main/java/com/rest/study/image/foodimage/entity/ImageMapping.java
package com.rest.study.image.foodimage.entity;
========
package com.rest.study.board.image.freeImage.entity;
>>>>>>>> yera2:study/src/main/java/com/rest/study/board/image/freeImage/entity/ImageMapping.java

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SequenceGenerator(name = "SEQ_MAPPING_ID", sequenceName = "SEQ_MAPPING_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ImageMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MAPPING_ID")
    private Long mappingId;

    @Column(nullable = false)
    private Long imageId;

    @Column(nullable = false)
    private String refTable;

    @Column(nullable = false)
    private Long refId;

}
