package edu.depaul.cdm.se452.demo.controller;

import edu.depaul.cdm.se452.demo.model.AirportRepository;
import edu.depaul.cdm.se452.demo.model.Airport;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/airport")
@SessionAttributes("sessionAirport")
public class AirportController {

    private AirportRepository repo;
    
    public AirportController(AirportRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("airports", repo.findAll());
        return "airports/list";
    }

    @GetMapping(params = "add")
    public String add(Model model) {
        model.addAttribute("airport", new Airport());
        return "airports/form";
    }

    @GetMapping(params = "edit")
    public ModelAndView edit(@RequestParam String code) {
        ModelAndView mav = new ModelAndView("/airports/form");
        Airport airport = repo.findByCode(code);
        mav.addObject(airport);
        return mav;
    }

    @GetMapping(params = "delete")
    public String delete(@RequestParam String code) {
        Airport airport = repo.findByCode(code);
        repo.delete(airport);
        return "redirect:/airport";
    }
    
    @PostMapping
    public String saveFlight(@ModelAttribute("airport") Airport airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airports/form";
        }

        repo.save(airport);

        return "redirect:/airport";
    }

}
