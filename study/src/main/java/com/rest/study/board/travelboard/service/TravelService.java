package com.rest.study.board.travelboard.service;

import com.rest.study.board.travelboard.entity.Travel;

import java.util.List;

public interface TravelService {
    List<Travel> findAll();

    void deleteById(Long id); // 리턴값 없음
}
