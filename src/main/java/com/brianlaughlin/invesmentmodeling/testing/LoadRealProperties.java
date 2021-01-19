package com.brianlaughlin.invesmentmodeling.testing;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.brianlaughlin.invesmentmodeling.citiesandproperty.PropertyStatus.ESCROW;

public class LoadRealProperties {
    List<Property> properties = new ArrayList<>();

    public LoadRealProperties() {
        Property p1 = new Property("Detroit", "19127 Tireman", "48228", 750.0,
                0.08, 9000.0, 37000.0, ESCROW);
        Property p2 = new Property("Detroit", "6112 Neff Ave", "48224", 750.0,
                0.08, 6000.0, 38000.0, ESCROW);
        Property p3 = new Property("Detroit", "13926 Rockdale St", "48223", 750.0,
                0.08, 6000.0, 35000.0, ESCROW);
        Property p4 = new Property("Detroit", "13934 Rockdale St", "48223", 850.0,
                0.08, 6000.0, 35000.0, ESCROW);
        Property p5 = new Property("Detroit", "12014 Conner Ave.", "48205", 1200.0,
                0.08, 13000.0, 65000.0, ESCROW);

        for (Property property : Arrays.asList(p1, p2, p3, p4, p5)) {
            properties.add(property);
        }
    }

    public List<Property> LoadRealPropertiesWithLoan() {
        Property p1 = new Property("Detroit", "19127 Tireman", "48228", 750.0, 0.08, 9000.0, 37000.0);
        Property p2 = new Property("Detroit", "6112 Neff Ave", "48224", 750.0, 0.08, 6000.0, 38000.0);
        Property p3 = new Property("Detroit", "13926 Rockdale St", "48223", 750.0, 0.08, 6000.0, 35000.0);
        Property p4 = new Property("Detroit", "13934 Rockdale St", "48223", 850.0, 0.08, 6000.0, 35000.0);
        Property p5 = new Property("Detroit", "12014 Conner Ave.", "48205", 1200.0, 0.08, 13000.0, 65000.0);

        for (Property property1 : Arrays.asList(p1, p2, p3, p4, p5)) {
            property1.setLoanAmount(p1.getPurchasePrice() * 0.75);
        }

        properties.clear();

        for (Property property : Arrays.asList(p1, p2, p3, p4, p5)) {
            properties.add(property);
        }

        return properties;
    }


    public List<Property> getProperties() {
        return properties;
    }
}
