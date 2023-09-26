package com.rest.study.board.freeboard.service;

import com.rest.study.board.freeboard.entity.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FreeBoardService {
    List<FreeBoard> findAll();
}
