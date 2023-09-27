package com.rest.study.board.freeboard.controller;

import com.rest.study.board.freeboard.dto.FreeBoardDto;
import com.rest.study.board.freeboard.entity.FreeBoard;
import com.rest.study.board.freeboard.service.FreeBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/freeboards")
@RestController
@Slf4j
public class FreeBoardController {

    @Autowired
    private FreeBoardService freeBoardService;

    @GetMapping
    public ResponseEntity<?> getBoards() {
        return ResponseEntity.ok(freeBoardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Long id) {
        FreeBoard freeBoard = freeBoardService.findById(id);
        if(freeBoard == null)
            return ResponseEntity.notFound().build();
        return  ResponseEntity.ok(freeBoard);
    }

    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody FreeBoard freeBoard) {
        FreeBoard saveBoard = freeBoardService.save(freeBoard);
        return new ResponseEntity(saveBoard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBoard(@PathVariable("id") Long id, @RequestBody FreeBoardDto freeBoardDto) {
        FreeBoard freeBoard = freeBoardService.findById(id);
        freeBoardDto.toFreeBoardDto(freeBoard);
        freeBoardService.save(freeBoard);
        return ResponseEntity.ok(freeBoardService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id){
        freeBoardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
