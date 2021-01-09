package com.brianlaughlin.invesmentmodeling;

import com.brianlaughlin.invesmentmodeling.model.City;
import com.brianlaughlin.invesmentmodeling.model.Detroit;
import com.brianlaughlin.invesmentmodeling.model.Property;

public class Testing {
    public static void main(String[] args) {
        System.out.println("Hello there");

        City detroit = new Detroit();
        Property property = new Property("Detroit", 40000.00);

        System.out.println("Property tax in " + property.getCityName() + " is "
        + property.getPropertyTaxYearly() + "/yr");

        System.out.println(property.toString());

    }
}
