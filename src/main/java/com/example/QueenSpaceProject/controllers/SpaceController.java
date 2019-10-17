package com.example.QueenSpaceProject.controllers;

import com.example.QueenSpaceProject.dao.SpaceDAO;
import com.example.QueenSpaceProject.models.Facts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Controller
@RequestMapping("display")
public class SpaceController {

    @Autowired
    private SpaceDAO spaceDAO;

    @GetMapping()
    public String listFacts(Model model) {
        List<Facts> facts = spaceDAO.getAll();
        model.addAttribute(("facts"), facts);
        return "facts";
    }

    @PostMapping(value = "new")
    public String addFact(@RequestParam String fact) {
        System.out.println("Adding space fact: " + fact);
        spaceDAO.addSpaceFact(new Facts(1, fact));
        return "redirect:";
    }

    @GetMapping("/{id}/edit")
    public String viewFactToEdit(Model model, @PathVariable int id) {
        Facts spaceFact = spaceDAO.findById(id);
        model.addAttribute("fact", spaceFact);
        return "factEdit.html";
    }

    @PostMapping("/{id}/edit")
    public String editSpaceFact(@ModelAttribute Facts fact, @PathVariable int id) {
        spaceDAO.updateSpaceFact(id, fact);
        return "redirect:/display";
    }

    @RequestMapping("about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        model.addAttribute("keyword", keyword);
        List<Facts> facts = spaceDAO.findByString(keyword);
        model.addAttribute("facts", facts);
        return "search";
    }
}



