/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.se452.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookies")
public class CookiesController {
    @PostMapping
    public String post(HttpServletResponse response, Model model) {
        Cookie newCookie = new Cookie("person", "Cookie_Monster");
        newCookie.setMaxAge(30);
        response.addCookie(newCookie);
        model.addAttribute("name", newCookie.getValue());
        return "greeting";
    }
    
    @GetMapping
    public String get(
            @CookieValue(value="person", defaultValue="nothing") String cookie, 
            Model model) {
        
        
        model.addAttribute("name", cookie);
        return "greeting";
    }
    
}
