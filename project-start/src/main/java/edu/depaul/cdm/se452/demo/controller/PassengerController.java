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
public class PassengerController implements WebMvcConfigurer {
    @GetMapping("/passenger")
    public String showForm(Passenger passenger) {
        return "simpleform";
    }

    @PostMapping("/passenger")
    public String checkPersonInfo(@Valid Passenger passenger, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "simpleform";
        }

        return "results";
    }
}
