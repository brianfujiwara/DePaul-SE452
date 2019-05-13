package edu.depaul.cdm.se452.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionData")
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

    @GetMapping("/setcookie")
    public String setCookie(HttpServletResponse response, Model model) {
        Cookie newCookie = new Cookie("cookieType", "chocolateChip");
        newCookie.setMaxAge(0);
        response.addCookie(newCookie);
        model.addAttribute("name", "Dave");
        return "greeting";
    }
    
    @GetMapping("/getcookie")
    public String getCookie(
            @CookieValue(value="cookieType", defaultValue="nothing") String cookie, 
            Model model) {
        model.addAttribute("name", "Dave");
        return "greeting";
    }

    @GetMapping("/setsession")
    public String setSession(Model model) {
        model.addAttribute("name", "Dave");
        model.addAttribute("sessionData", "myTestData");
        return "greeting";
    }
    
    @GetMapping("/getsession")
    public String getSession(Model model) {
        model.addAttribute("name", "Dave");
        String sessionData = (String) model.asMap().getOrDefault("sessionData", "nothing");
        model.addAttribute("sessionData", "myTestData");
        return "greeting";
    }
    
}
