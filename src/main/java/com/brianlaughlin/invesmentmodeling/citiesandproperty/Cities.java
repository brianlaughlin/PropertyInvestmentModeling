package com.brianlaughlin.invesmentmodeling.citiesandproperty;

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
