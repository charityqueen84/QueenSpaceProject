package com.example.QueenSpaceProject.controllers;

import com.example.QueenSpaceProject.models.Facts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SpaceController {

    private static List<Facts> facts;

    public SpaceController() {
        facts = new ArrayList<Facts>();
        facts.add(new Facts("Neptune’s\n" +
                "giant, spinning storms could swallow the whole Earth. "));
        facts.add(new Facts("Saturn is the only planet in our solar system that is less\n" +
                "dense than water. It could float in a bathtub."));
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
        System.out.println("Loading space facts");
        model.addAttribute("facts", facts);
        model.addAttribute("count", 5);
        return "facts";
    }

    @RequestMapping(value = "new")
    public String addFact(Model model, @RequestParam String spaceFactField) {
        System.out.println("Adding space facts: " + spaceFactField);
        facts.add(new Facts(spaceFactField));
        return "redirect:";
    }
}
