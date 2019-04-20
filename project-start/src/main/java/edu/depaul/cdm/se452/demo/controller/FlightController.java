package edu.depaul.cdm.se452.demo.controller;

import edu.depaul.cdm.se452.demo.model.Flight;
import edu.depaul.cdm.se452.demo.model.FlightRepository;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
    private FlightRepository repo;
    
    public FlightController(FlightRepository repo) {
        this.repo = repo;
    }
    
    @GetMapping("/flights")
    public Collection<Flight> flights() {
        return repo.findAll().stream().collect(Collectors.toList());
    }
}
