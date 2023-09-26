package com.rest.study;

import com.rest.study.board.travelboard.entity.TravelBoard;
import com.rest.study.board.travelboard.repository.TravelBoardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@SpringBootTest
public class TravelBoardTest {

    @Autowired
    TravelBoardRepository travelBoardRepository;

    @Test
    public void testJpa() {
        TravelBoard t1 = new TravelBoard();
        t1.setTravelTitle("안녕하세요");
        t1.setTravelContent("여행게시판입니다안녕하세요김대원입니다.");
        t1.setTravelMemberId("king");
        t1.setTravelCreatedAt(LocalDateTime.now());
        this.travelBoardRepository.save(t1);
    }

}
