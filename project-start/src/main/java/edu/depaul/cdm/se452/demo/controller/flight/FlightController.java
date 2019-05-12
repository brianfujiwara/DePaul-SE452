package edu.depaul.cdm.se452.demo.controller.flight;

import edu.depaul.cdm.se452.demo.model.Flight;
import edu.depaul.cdm.se452.demo.model.FlightRepository;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FlightController {
    private FlightRepository repo;
    
    public FlightController(FlightRepository repo) {
        this.repo = repo;
    }
    
    @GetMapping("/flights")
    public String showAll(Model model) {
        model.addAttribute("flights", repo.findAll());
        return "flights/allflights";
    }

    @GetMapping("/flights/create")
    public String showCreateForm(Model model) {
        Flight flight = new Flight();
        model.addAttribute("flight", flight);
        return "flights/addflight";
    }
    
    @PostMapping("/flights/save")
    public String saveFlight(@Valid Flight flight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "flights/addflight";
        }
        repo.save(flight);
        return "redirect:/flights";
    }
}
