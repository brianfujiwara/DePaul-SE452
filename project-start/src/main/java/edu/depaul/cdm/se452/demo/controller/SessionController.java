package edu.depaul.cdm.se452.demo.controller;

import edu.depaul.cdm.se452.demo.model.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Demo of Session in action
 */
@Controller
@SessionAttributes("passenger")
public class SessionController {
    
    // Define default session value
    @ModelAttribute("passenger")
    public Passenger getPassenger() {
        return new Passenger();
    }
    
    @GetMapping("/setsession")
    public String setSession(Model model, @ModelAttribute("passenger") Passenger passenger) {
        passenger.setName("Dave Session");
        model.addAttribute("passenger", passenger);
        model.addAttribute("name", passenger.getName());
        return "greeting";
    }
    
    @GetMapping("/getsession")
    public String getSession(Model model, @ModelAttribute("passenger") Passenger passenger) {
        model.addAttribute("name", passenger.getName());
        return "greeting";
    }
}
