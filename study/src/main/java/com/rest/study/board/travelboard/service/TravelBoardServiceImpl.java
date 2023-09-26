package com.rest.study.board.travelboard.service;

import com.rest.study.board.travelboard.entity.TravelBoard;
import com.rest.study.board.travelboard.repository.TravelBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TravelBoardServiceImpl implements TravelBoardService {

    @Autowired
    private TravelBoardRepository travelRepository;


}
