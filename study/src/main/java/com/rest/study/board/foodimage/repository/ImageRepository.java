package com.rest.study.board.foodimage.repository;

import com.rest.study.board.foodimage.entity.ImageAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageAttachment, Long> {



    List<ImageAttachment> findByFoodBoard_foodId(Long id);
}
