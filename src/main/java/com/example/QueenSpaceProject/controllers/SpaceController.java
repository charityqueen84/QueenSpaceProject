package com.example.QueenSpaceProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SpaceController {

    @RequestMapping(value = " ")
    public String index() {
        return "index";

    }
    @RequestMapping(value = "space")
    public String space() {
        return "space";
    }
    @RequestMapping(value = "display")
    public String displayFacts(Model model) {

        model.addAttribute("count", 5);
        return "facts";
    }



}
