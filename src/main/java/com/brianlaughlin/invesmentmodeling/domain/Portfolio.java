package com.brianlaughlin.invesmentmodeling.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Portfolio {

    @Id
    @GeneratedValue
    private Long id;

    // Location
    String street;
    String zipcode;
    String notes;
    Integer neighborhoodRating;

    // Financials
    Double rent = 0.0;
    Double propertyManagementRate = 0.1;
    Double loanAmount = 0.0;
    Double rehab = 0.0;
    Double deferedMaintenance = 0.0;
    Double vacancyRate = 0.0;
    Double hoa = 0.0;
    Double interestRate = 0.085; // 8.5%
    Double purchasePrice = 0.0;
    Double estARV = 0.0;
}
