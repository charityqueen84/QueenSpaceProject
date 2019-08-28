package com.example.QueenSpaceProject.controllers;

import com.example.QueenSpaceProject.models.Facts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("display")
public class SpaceController {

    private static List<Facts> facts;
    public SpaceController() {
        facts = new ArrayList<Facts>();
        facts.add(new Facts("Neptune’s\n" +
                "giant, spinning storms could swallow the whole Earth.  "));
        facts.add(new Facts("Saturn is the only planet in our solar system that is less\n" +
                "dense than water. It could float in a bathtub."));
    }

    @RequestMapping(value = "space")
    public String space() {
        return "space";
    }
    @RequestMapping(value = "")
    public String displayFacts(Model model) {
        System.out.println("Loading space facts");
        model.addAttribute("facts", facts);       //facts is a string, facts is the object (arraylist)
                                               //removed model.addAttribute("count", 5);
        return "facts";
    }

    @RequestMapping(value = "about") //does this need to be a GET? either way, same result
    public String about(Model model) {
        return "about";  //need to link css and it needs to return /display/about - cheese tutorial - we covered this. it works when I go to localhost:8080/display/about
    }
    @RequestMapping(value = "new")
    public String addFact(Model model, @RequestParam String spaceFactField ) {
        System.out.println("Adding space fact: " + spaceFactField);
        facts.add(new Facts(spaceFactField));
        return "redirect:";
    }
    //@RequestMapping(value = "/*"    )
    //public String prettyDisplay() {
    //    return "redirect:";
    //}
}
