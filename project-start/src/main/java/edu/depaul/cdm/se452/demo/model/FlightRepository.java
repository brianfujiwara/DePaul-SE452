package edu.depaul.cdm.se452.demo.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * FlightRepository
 */
@RepositoryRestResource
public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByFlightNumber(String flightNum); 
    
    @Override
    List<Flight> findAll();
}