package com.rest.study.board.foodboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StaticController {

    @RequestMapping("/foodboards")
    public String getFoodBoards() { return "forward:/foodboard/foodBoard_list.html"; }

    @RequestMapping(value="/foodboards/{id}", method= RequestMethod.GET)
    public String getFoodBoard() {return "forward:/foodboard/foodBoard_detail.html";}

    @RequestMapping(value="/foodboards/writeBoard", method= RequestMethod.GET)
    public String writeFoodBoard() {return "forward:/foodboard/foodBoard_write.html";}


    @RequestMapping("/freeboards")
    public String freeBoards() {
        return "forward:/freeBoard_list.html";
    }
}
