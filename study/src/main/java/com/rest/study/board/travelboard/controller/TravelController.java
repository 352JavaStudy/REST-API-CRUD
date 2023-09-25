package com.rest.study.board.travelboard.controller;


import javax.validation.Valid;

import com.rest.study.board.travelboard.dto.TravelDto;
import com.rest.study.board.travelboard.entity.Travel;
import com.rest.study.board.travelboard.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:8080")
@RestController // @Controller인데 모든핸들러에 @ResponseBody어노테이션을 적용해준다.
@RequestMapping("/travel")
@Slf4j
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(travelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Travel travel = travelService.findById(id);
        if(travel == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(travel);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable Long id) {
        travelService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }






}
