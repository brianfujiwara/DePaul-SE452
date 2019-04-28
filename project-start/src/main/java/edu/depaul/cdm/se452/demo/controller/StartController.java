package edu.depaul.cdm.se452.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartController {
  
    @GetMapping("/hello")
    public String greeting1(Model model) {
        model.addAttribute("name", "Dave");
        return "greeting";
    }
    
    @GetMapping("/hello1")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
}
