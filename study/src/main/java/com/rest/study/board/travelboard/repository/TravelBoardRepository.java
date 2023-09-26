package com.rest.study.board.travelboard.repository;

import com.rest.study.board.travelboard.entity.TravelBoard
        ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelBoardRepository extends JpaRepository<TravelBoard, Long> {


}
