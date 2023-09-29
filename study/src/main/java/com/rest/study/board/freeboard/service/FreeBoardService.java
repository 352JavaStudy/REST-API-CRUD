package com.rest.study.board.freeboard.service;

import com.rest.study.board.freeboard.dto.FreeBoardReadDto;
import com.rest.study.board.freeboard.entity.FreeBoard;

import java.util.List;


public interface FreeBoardService {
    List<FreeBoard> findAllByOrderByFreeIdDesc();

    FreeBoardReadDto findById(Long id);

    FreeBoard save(FreeBoard freeBoard);

    void deleteById(Long id);
}
