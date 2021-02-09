package com.brianlaughlin.invesmentmodeling.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Portfolio {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date date;


    // Location
    String street;
    String zipcode;
    String city;
    String notes;
    Integer neighborhoodRating;

    // Financials
    Double rent = 0.0;
    Double propertyManagementRate = 0.08;
    Double loanAmount = 0.0;
    Double rehab = 0.0;
    Double deferedMaintenance = 0.0;
    Double vacancyRate = 0.0;
    Double hoa = 0.0;
    Double interestRate = 0.08; // 8.0%
    Double purchasePrice = 0.0;
    Double estARV = 0.0;

}
