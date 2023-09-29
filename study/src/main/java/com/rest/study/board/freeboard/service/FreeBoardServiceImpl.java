package com.rest.study.board.freeboard.service;

import com.rest.study.board.freeboard.dto.FreeBoardDto;
import com.rest.study.board.freeboard.dto.FreeBoardReadDto;
import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.freeboard.repository.FreeBoardRepository;
import com.rest.study.user.entity.User;
import com.rest.study.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FreeBoardServiceImpl implements FreeBoardService{

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FreeBoard> findAllByOrderByFreeIdDesc() {
        return freeBoardRepository.findAllByOrderByFreeIdDesc();
    }

    @Override
    public FreeBoardReadDto findBoard(Long id) {
        return FreeBoardReadDto.toDto(freeBoardRepository.findById(id).orElse(null));
    }

    @Override
    public FreeBoard save(FreeBoard freeBoard) {
        return freeBoardRepository.save(freeBoard);
    }

    @Override
    public void deleteBoard(Long id) {
        freeBoardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public FreeBoardReadDto editBoard(Long id, FreeBoardDto updateDto, User user) {
        FreeBoard freeBoard = freeBoardRepository.findById(id).orElseThrow();
        freeBoard.setFreeTitle(updateDto.getFreeTitle());
        freeBoard.setFreeContent(updateDto.getFreeContent());
        freeBoard.setUser(user);
        FreeBoard updatedFreeBoard = freeBoardRepository.save(freeBoard);
        return FreeBoardReadDto.toDto(updatedFreeBoard);
    }
}
