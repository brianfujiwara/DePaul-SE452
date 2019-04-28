package edu.depaul.cdm.se452.demo.controller;

import edu.depaul.cdm.se452.demo.model.Passenger;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class FancyPassengerController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/fancypassenger")
    public String showForm(Passenger passenger) {
        return "formv2";
    }

    @PostMapping("/fancypassenger")
    public String checkPersonInfo(@Valid Passenger passenger, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "formv2";
        }

        return "redirect:/results";
    }
}
