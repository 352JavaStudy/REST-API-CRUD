package com.rest.study;

import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.freeboard.repository.FreeBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class FreeBoardTests {

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Test
    void testJpa() {
        FreeBoard q1 = new FreeBoard();
        q1.setFreeTitle("배가 고파요");
        q1.setFreeContent("1. 피자 2. 치킨 뭐 먹을까요?");
        q1.setFreeMemberId("member1");
        q1.setFreeCreatedAt(LocalDateTime.now());
        this.freeBoardRepository.save(q1);
    }
}
