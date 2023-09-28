package com.rest.study.board.foodboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController {

    @RequestMapping("/foodboards")
    public String fooBoards() { return "forward:/foodBoard_list.html"; }

    @RequestMapping("/freeboards")
    public String freeBoards() {
        return "forward:/freeBoard_list.html";
    }

}
