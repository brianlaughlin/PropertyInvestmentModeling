package com.brianlaughlin.invesmentmodeling.citiesandproperty.florida;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.City;

public class Jacksonville extends City {
    public Jacksonville() {
        name = "Jacksonville";
        taxRate = 0.0101; // 1.01%
        state = "FL";
        investmentReturnMinimum = 0.12;
        defaultRehab = 8000.0;
    }
}
