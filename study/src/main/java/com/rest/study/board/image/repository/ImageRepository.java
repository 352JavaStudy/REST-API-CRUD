package com.rest.study.board.image.repository;

import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
