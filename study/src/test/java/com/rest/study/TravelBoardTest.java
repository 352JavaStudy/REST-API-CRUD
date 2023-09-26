package com.rest.study;

import com.rest.study.board.travelboard.entity.TravelBoard;
import com.rest.study.board.travelboard.repository.TravelBoardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
public class TravelBoardTest {

    @Autowired
    TravelBoardRepository travelBoardRepository;

    @Test
    public void testJpa() {
        TravelBoard travel = new TravelBoard();
        travel.setTravelTitle("여행 제목");
        travel.setTravelContent("여행게시판입니다안녕하세요김대원입니다.");
        travel.setTravelMemberId("king");
        travel.setTravelCreatedAt(LocalDateTime.now());
        this.travelBoardRepository.save(travel);
    }

}
