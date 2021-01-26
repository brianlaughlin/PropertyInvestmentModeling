package com.brianlaughlin.invesmentmodeling.testing;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.brianlaughlin.invesmentmodeling.citiesandproperty.PropertyStatus.*;

public class LoadRealProperties {
    List<Property> properties = new ArrayList<>();

    public LoadRealProperties() {
        Property p1 = new Property("Detroit", "19127 Tireman", "48228", 750.0,
                0.08, 9000.0, 37000.0, CANCELLED);
        Property p2 = new Property("Detroit", "6112 Neff Ave", "48224", 750.0,
                0.08, 5000.0, 36000.0, ESCROW);
        Property p3 = new Property("Detroit", "13926 Rockdale St", "48223", 750.0,
                0.08, 6000.0, 35000.0, CANCELLED);
        Property p4 = new Property("Detroit", "13934 Rockdale St", "48223", 850.0,
                0.08, 6000.0, 35000.0, CANCELLED);
        Property p5 = new Property("Detroit", "12014 Conner Ave.", "48205", 1200.0,
                0.08, 13000.0, 65000.0, CANCELLED);
        Property p6 = new Property("Detroit", "15639 Fairmount Dr", "48205", 750.0,
                0.08, 3000.0, 35000.0, ESCROW);
        Property p7 = new Property("Jacksonville", "4519 Friden Drive", "32209", 785.0,
                0.08, 13500.0, 40000.0, ESCROW);
        Property p8 = new Property("Jacksonville", "7936 Siskin Ave", "32219", 975.0,
                0.08, 11000.0, 49000.0, OFFER_MADE);
        Property p9 = new Property("Jacksonville", "1832 Jones St", "32206", 750.0,
                0.08, 12000.0, 39000.0, OFFER_MADE);
        Property p10 = new Property("Detroit", "17364 Asbury Park", "48235", 850.0,
                0.08, 2000.0, 41000.0, ESCROW);
        Property p11 = new Property("Detroit", "11446 Kennebec St", "48205", 700.0,
                0.08, 3000.0, 35000.0, ESCROW);
        Property p12 = new Property("Detroit", "20153 Stoepel", "48221", 700.0,
                0.08, 3000.0, 35000.0, ESCROW);
        Property p13 = new Property("Detroit", "9951 Sussex St", "48227", 800.0,
                0.08, 3000.0, 38000.0, ESCROW);

        for (Property property : Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)) {
            properties.add(property);
        }
    }

    public List<Property> LoadRealPropertiesWithLoan() {
        Property p1 = new Property("Detroit", "19127 Tireman", "48228", 750.0, 0.08, 9000.0, 37000.0);
        Property p2 = new Property("Detroit", "6112 Neff Ave", "48224", 750.0, 0.08, 6000.0, 38000.0);
        Property p3 = new Property("Detroit", "13926 Rockdale St", "48223", 750.0, 0.08, 6000.0, 35000.0);
        Property p4 = new Property("Detroit", "13934 Rockdale St", "48223", 850.0, 0.08, 6000.0, 35000.0);
        Property p5 = new Property("Detroit", "12014 Conner Ave.", "48205", 1200.0, 0.08, 13000.0, 65000.0);
        Property p6 = new Property("Detroit", "15639 Fairmount Dr", "48205", 750.0,
                0.08, 3000.0, 35000.0, ESCROW);
        Property p7 = new Property("Jacksonville", "4519 Friden Drive", "32209", 785.0,
                0.08, 13500.0, 40000.0, ESCROW);
        Property p8 = new Property("Jacksonville", "7936 Siskin Ave", "32219", 975.0,
                0.08, 11000.0, 49000.0, OFFER_MADE);
        Property p9 = new Property("Jacksonville", "1832 Jones St", "32206", 750.0,
                0.08, 12000.0, 39000.0, OFFER_MADE);

        for (Property property1 : Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9)) {
            property1.setLoanAmount(p1.getPurchasePrice() * 0.75);
        }

        properties.clear();

        for (Property property : Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9)) {
            properties.add(property);
        }

        return properties;
    }


    public List<Property> getProperties() {
        return properties;
    }
}
