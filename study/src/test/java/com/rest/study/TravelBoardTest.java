package com.rest.study;

import com.rest.study.board.travelboard.entity.Travel;
import com.rest.study.board.travelboard.service.TravelService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class TravelBoardTest {
    Logger logger = LoggerFactory.getLogger(TravelBoardTest.class);

    @Autowired
    TravelService travelService;

    @Test
    public void testGetTravelBoardList() {



    }


}
