package com.rest.study.image.foodimage.repository;

import com.rest.study.image.foodimage.entity.ImageAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageAttachment, Long> {

    List<ImageAttachment> findByFoodBoard_foodId(Long id);

    ImageAttachment findByUniqueName(String uniqueName);
}
