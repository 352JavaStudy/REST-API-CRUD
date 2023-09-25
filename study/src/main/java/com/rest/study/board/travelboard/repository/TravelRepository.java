package com.rest.study.board.travelboard.repository;

import com.rest.study.board.travelboard.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
