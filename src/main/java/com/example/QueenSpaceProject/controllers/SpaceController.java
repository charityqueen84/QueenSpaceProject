package com.example.QueenSpaceProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SpaceController {

    private static List<String> facts;
    public SpaceController() {
        facts = new ArrayList<String>();
        facts.add("Giant, spinning storms on Neptune are big enough to swallow the whole Earth.");
        facts.add("Saturn is the only planet in our solar system that is less\n" +
                "dense than water. It could float in a bathtub.");
    }

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
        model.addAttribute("facts", facts);
        model.addAttribute("count", 5);
        return "facts";
    }



}
