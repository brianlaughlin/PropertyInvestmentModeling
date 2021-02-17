package com.brianlaughlin.invesmentmodeling.citiesandproperty.california;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.City;

public class SantaAna extends City {
    public SantaAna() {
        name = "Santa Ana";
        taxRate = 0.011;  // 2.69%
        state = "CA";
        investmentReturnMinimum = 0.065;
        defaultRehab = 7000.0;
        defaultInsuranceRate = 0.015;
    }
}
