package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import lombok.Data;

@Data
public class Location {// Location
    String street;
    String zipcode;
    Integer neighborhoodRating;

    public Location() {
        this.street = "";
        this.zipcode = "";
        this.neighborhoodRating = 0;
    }

    public Location(String street, String zipcode) {
        this.street = street;
        this.zipcode = zipcode;
    }


}