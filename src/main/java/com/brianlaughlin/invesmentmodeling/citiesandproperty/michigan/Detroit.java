package com.brianlaughlin.invesmentmodeling.citiesandproperty.michigan;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.City;

public class Detroit extends City {
    public Detroit() {
        name = "Detroit";
        taxRate = 0.0269;  // 2.69%
        state = "MI";
        investmentReturnMinimum = 0.14;
        defaultRehab = 3000.0;
    }
}
