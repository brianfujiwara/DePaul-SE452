package edu.depaul.cdm.se452.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "reviews")
public class FlightReview implements Serializable{
    private String flightNum;
    private String review;
    private String reviewer;
    private Date reviewDate;
}
