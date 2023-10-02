package com.rest.study.image.freeImage.repository;

import com.rest.study.board.image.freeImage.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
