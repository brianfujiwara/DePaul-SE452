package edu.depaul.cdm.se452.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Sample to show Cookie in action
 */
@Controller
public class CookieController {
    @PostMapping("/cookie")
    public String post(HttpServletResponse response, Model model) {
        Cookie newCookie = new Cookie("person", "Cookie-Monster");
        /*
         * Change the max age to following to see what happens
         *    1) 0
         *    2) 30
         *    3) comment it out
         *    4) change name to be Cookie Monster
         */    
//        newCookie.setMaxAge(0);
        response.addCookie(newCookie);
        model.addAttribute("name", newCookie.getValue());
        return "greeting";
    }
    
    @GetMapping("/cookie")
    public String get(
            @CookieValue(value="person", defaultValue="nothing") String cookie, 
            Model model) {
        
        
        model.addAttribute("name", cookie);
        return "greeting";
    }
    
}
