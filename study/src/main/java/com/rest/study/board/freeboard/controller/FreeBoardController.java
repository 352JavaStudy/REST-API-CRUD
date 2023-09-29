package com.rest.study.board.freeboard.controller;

import com.rest.study.board.freeboard.dto.FreeBoardReadDto;
import com.rest.study.board.freeboard.dto.FreeBoardUpdateDto;
import com.rest.study.user.entity.User;
import com.rest.study.user.service.UserService;
import com.rest.study.board.freeboard.dto.FreeBoardDto;
import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.freeboard.service.FreeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost")
@RequestMapping("/api/freeboards")
@RestController
@Slf4j
public class FreeBoardController {

    @Autowired
    private FreeBoardService freeBoardService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<FreeBoard>> getBoards() {
        List<FreeBoard> freeBoard = freeBoardService.findAllByOrderByFreeIdDesc();
        return ResponseEntity.ok(freeBoard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreeBoardReadDto> getBoard(@PathVariable Long id) {
        FreeBoardReadDto freeBoard = freeBoardService.findById(id);
        if(freeBoard == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(freeBoard);
    }

    @PostMapping("/write")
    public ResponseEntity<?> postBoard(@Valid @RequestBody FreeBoardDto freeBoardDto) {
        User user = userService.findByUserId(freeBoardDto.getFreeUserId());
        FreeBoard freeBoard = freeBoardDto.toFreeBoardDto(user);
        freeBoard = freeBoardService.save(freeBoard);
        return ResponseEntity.ok(freeBoard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreeBoardReadDto> putBoard(@PathVariable("id") Long id, @Valid @RequestBody FreeBoardUpdateDto updateDto) {
        FreeBoardReadDto freeBoardReadDto = freeBoardService.findById(id);
        User user = userService.findByUserId(updateDto.getFreeUserId());

        FreeBoard freeBoard = freeBoardReadDto.toFreeBoard();
        freeBoard = updateDto.toEntity(freeBoard, user);
        FreeBoard updatedFreeBoard = freeBoardService.save(freeBoard);

        FreeBoardReadDto readDto = FreeBoardReadDto.toDto(updatedFreeBoard);

        return ResponseEntity.ok(readDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id){
        freeBoardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}