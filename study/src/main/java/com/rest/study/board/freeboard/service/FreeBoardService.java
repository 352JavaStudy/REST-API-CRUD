package com.rest.study.board.freeboard.service;

import com.rest.study.board.freeboard.dto.FreeBoardDto;
import com.rest.study.board.freeboard.entity.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FreeBoardService {
    List<FreeBoard> findAll();

    FreeBoard findById(Long id);

    FreeBoard save(FreeBoard freeBoard);

    void deleteById(Long id);
}
