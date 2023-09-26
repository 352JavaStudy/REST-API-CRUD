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
        q1.setFreeTitle("자유 게시판에는 뭘 쓰면 되나요");
        q1.setFreeContent("반갑습니다");
        q1.setFreeCreatedAt(LocalDateTime.now());
        this.freeBoardRepository.save(q1);
    }
}
