package com.rest.study.board.travelboard.service;

import com.rest.study.board.travelboard.entity.Travel;
import com.rest.study.board.travelboard.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;


}
