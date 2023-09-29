package com.rest.study.board.freeboard.service;

import com.rest.study.board.freeboard.dto.FreeBoardReadDto;
import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.freeboard.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FreeBoardServiceImpl implements FreeBoardService{

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Override
    public List<FreeBoard> findAllByOrderByFreeIdDesc() {
        return freeBoardRepository.findAllByOrderByFreeIdDesc();
    }

    @Override
    public FreeBoardReadDto findById(Long id) {
        return FreeBoardReadDto.toDto(freeBoardRepository.findById(id).orElse(null));
    }

    @Override
    public FreeBoard save(FreeBoard freeBoard) {
        return freeBoardRepository.save(freeBoard);
    }

    @Override
    public void deleteById(Long id) {
        freeBoardRepository.deleteById(id);
    }

}
