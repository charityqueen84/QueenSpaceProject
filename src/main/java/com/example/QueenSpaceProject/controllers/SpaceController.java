package com.example.QueenSpaceProject.controllers;

import com.example.QueenSpaceProject.dao.SpaceDAO;
import com.example.QueenSpaceProject.models.Facts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("display")
public class SpaceController {

    @Autowired
    private SpaceDAO spaceDAO;

    @GetMapping()
    public String listFacts(Model model) { //added this to replace list
        List<Facts> facts = spaceDAO.getAll();
        model.addAttribute(("facts"), facts); //added parentheses around "facts"
        return "facts"; //this is the first page, where it lists any facts
    }

   //do I need a @GetMapping here for new returning redirect? - no I don't.
   @PostMapping(value = "new")
   public String addFact(@RequestParam String fact) {
       System.out.println("Adding space fact: " + fact);
       spaceDAO.addSpaceFact(new Facts(1, fact));
       return "redirect:"; //returns you back to facts after you add a fact
   }

   //This should load the edit form when I click on edit from the facts page.
    @GetMapping("/{id}/edit") //maybe the best way to think about this is that the "get" mapping returns the page where you are editing a fact
    public String viewFactToEdit(Model model, @PathVariable int id) {
        Facts spaceFact = spaceDAO.findById(id); //facts was galaxy and spaceFact, neither worked. facts didn't work either.
        model.addAttribute("fact", spaceFact); //facts was galaxy and spaceFact, neither worked.
        return "factEdit.html";
    }
   //This should allow me to edit a space fact, save the changes, and redirect me back to factEdit.html
   @PostMapping("/{id}/edit") //the "post" mapping takes the updated bookmark from the form submit and saves it.
    public  String editSpaceFact (@ModelAttribute Facts fact, @PathVariable int id) { //facts was galaxy and spaceFact, neither worked
        spaceDAO.updateSpaceFact(id, fact); //facts was galaxy and spaceFact, neither worked
        return "redirect:/display";
   }



   //@PostMapping(value = "") //do I actually need this method?
   //public String displayFacts(Model model, @PathVariable String facts) { //changed method name from displayFacts to editFacts - changed back.
   //    System.out.println("Loading space facts");
   //    model.addAttribute("facts", facts);
   //    return "facts";
   //}  //commented out to see if I actually need this
//

    }

    //private static List<Facts> facts;
    //public SpaceController() {
    //    facts = new ArrayList<Facts>();
    //    facts.add(new Facts("Neptune’s\n" +
    //            "giant, spinning storms could swallow the whole Earth.  "));
    //    facts.add(new Facts("Saturn is the only planet in our solar system that is less\n" +
    //            "dense than water. It could float in a bathtub."));
    //}

    //@RequestMapping(value = "space")   //defaults to get  - this was just a page that said "Space is Rad"
    //public String space() {
    //    return "space";
    //}
    //@RequestMapping(value = "")
    //public String displayFacts(Model model) {
    //    System.out.println("Loading space facts");
    //    model.addAttribute("facts", facts);       //facts is a string, facts is the object (arraylist)
    //                                           //removed model.addAttribute("count", 5);
    //    return "facts";
    //}

    //@RequestMapping(value = "about") //does this need to be a GET? either way, same result
    //public String about(Model model) {
    //    return "about";  //need to link css and it needs to return /display/about - cheese tutorial - we covered this. it works when I go to localhost:8080/display/about
    //}
    //@RequestMapping(value = "new")
    //public String addFact(Model model, @RequestParam String spaceFactField ) {
    //    System.out.println("Adding space fact: " + spaceFactField);
    //    facts.add(new Facts(spaceFactField));
    //    return "redirect:";
    //}
    //@RequestMapping(value = "/*"    )  /didn't end up needing this
    //public String prettyDisplay() {
    //    return "redirect:";
    //}
//}
