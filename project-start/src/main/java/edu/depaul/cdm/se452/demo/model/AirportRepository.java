package edu.depaul.cdm.se452.demo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Helps to perform CRUD operations for Airport
 */
@RepositoryRestResource
public interface AirportRepository extends CrudRepository<Airport, Long>  {
    Airport findByCode(String code);
}
