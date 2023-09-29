package com.rest.study.board.freeboard.service;

import com.rest.study.board.freeboard.dto.FreeBoardDto;
import com.rest.study.board.freeboard.dto.FreeBoardReadDto;
import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.user.entity.User;

import java.util.List;


public interface FreeBoardService {
    List<FreeBoard> findAllByOrderByFreeIdDesc();

    FreeBoardReadDto findBoard(Long id);

    FreeBoard save(FreeBoard freeBoard);

    void deleteBoard(Long id);

    FreeBoardReadDto editBoard(Long id, FreeBoardDto updateDto, User user);

}
