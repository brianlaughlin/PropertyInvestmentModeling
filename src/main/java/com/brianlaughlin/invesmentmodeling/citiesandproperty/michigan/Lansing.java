package com.brianlaughlin.invesmentmodeling.citiesandproperty.michigan;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.City;

public class Lansing extends City {
    public Lansing() {
        name = "Lansing";
        taxRate = 0.0152;
        state = "MI";
        investmentReturnMinimum = 0.12;
        defaultRehab = 3000.0;
        defaultInsuranceRate = 0.025; // I don't know what this is //todo: replace with actual rate
    }
}
