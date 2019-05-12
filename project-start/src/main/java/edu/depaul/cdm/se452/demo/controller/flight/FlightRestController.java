package edu.depaul.cdm.se452.demo.controller.flight;

import edu.depaul.cdm.se452.demo.model.Flight;
import edu.depaul.cdm.se452.demo.model.FlightRepository;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightRestController {
    private FlightRepository repo;
    
    public FlightRestController(FlightRepository repo) {
        this.repo = repo;
    }
    
    @GetMapping("/rest/flights")
    public Collection<Flight> flights() {
        return repo.findAll().stream().collect(Collectors.toList());
    }


}
