package com.rest.study.User.repository;

import com.rest.study.User.entity.User;
import com.rest.study.board.freeboard.entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<FreeBoard, Long> {

    User findByUserId(String freeUserId);
}
