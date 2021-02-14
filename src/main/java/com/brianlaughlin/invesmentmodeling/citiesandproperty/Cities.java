package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.florida.Jacksonville;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.michigan.Detroit;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.michigan.Lansing;

public class Cities {
    City city;

    protected void setCityClassByName(String cityName) {
        switch (cityName) {
            case "Detroit":
                this.city = new Detroit();
                break;
            case "Jacksonville":
                this.city = new Jacksonville();
                break;
            case "Lansing":
                this.city = new Lansing();
                break;
        }
    }
}
