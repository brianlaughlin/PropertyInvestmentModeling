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
    String city;
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
    Double interestRate = 0.08; // 8.0%
    Double purchasePrice = 0.0;
    Double estARV = 0.0;

    public Portfolio(Double rent, Double rehab, Double hoa, Double purchasePrice, String city) {
        this.rent = rent;
        this.rehab = rehab;
        this.hoa = hoa;
        this.purchasePrice = purchasePrice;
        this.city = city;
    }

    public Portfolio(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


}
