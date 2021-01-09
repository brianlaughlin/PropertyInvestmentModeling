package com.brianlaughlin.invesmentmodeling.model;

import com.brianlaughlin.invesmentmodeling.faker.StreetNameGenerator;
import lombok.Data;

@Data
public class Property {
    String street;
    String state;
    String zipcode;
    Double rent;
    Double propertyManagementRate;
    Double loanAmount;
    Double rehab;
    Double deferedMaintenance;
    Double vacancyRate;

    City city;

    Double purchasePrice;
    String notes;
    Integer neighborhoodRating;


    public Property(String cityName, Double purchasePrice) {
        this.purchasePrice = purchasePrice;
        switch (cityName) {
            case "Detroit":
                this.city = new Detroit();
                break;
            case "Jacksonville":
                this.city = new Jacksonville();
                break;
        }

        makeUpAddress();
    }

    public Double getPropertyTaxYearly() {
        return city.taxRate * purchasePrice;
    }

    public Double getPropertyTaxMontly() {
        return city.taxRate * purchasePrice / 12;
    }

    public String getCityName(){
        return city.name;
    }

    private void makeUpAddress(){
        this.street = StreetNameGenerator.generateAddress();
    }
}
