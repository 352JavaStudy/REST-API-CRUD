package com.rest.study.board.foodboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticController {

    @RequestMapping("/foodboards")
    public String foodBoards() { return "forward:/foodBoard_list.html"; }

    @RequestMapping(value ="/freeboards", method = RequestMethod.GET)
    public String freeBoards() { return "forward:/freeboard/freeBoard_list.html";
    }

    @RequestMapping(value = "/freeboards/{id}", method = RequestMethod.GET)
    public String freeBoardDetail() {
        return "forward:/freeboard/freeBoard_detail.html";
    }

    @RequestMapping(value = "/freeboards/writeBoard", method = RequestMethod.GET)
    public String writeBoard() { return "forward:/freeboard/freeBoard_write.html";
    }
}
