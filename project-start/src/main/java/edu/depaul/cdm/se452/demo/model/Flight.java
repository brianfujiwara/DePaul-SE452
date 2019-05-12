package edu.depaul.cdm.se452.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "flights")
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "origination_airport", nullable = false)
    @JsonIgnore
    private Airport originationAirport;

    @ManyToOne
    @JoinColumn(name = "destination_airport", nullable = false)    
    @JsonIgnore
    private Airport destinationAirport;

    
 //   @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="departure_dt")
    private LocalDate departureDate;

    @Column(name="departure_tm")
//    @Temporal(TemporalType.TIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime departureTime;
    
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate arrivalDate;
    
//    @Temporal(TemporalType.TIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime arrivalTime;
    
}
