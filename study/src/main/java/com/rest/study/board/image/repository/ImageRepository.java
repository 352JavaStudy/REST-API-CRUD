package com.rest.study.board.image.repository;

import com.rest.study.board.image.entity.ImageAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageAttachment, Long> {
}
