package com.brianlaughlin.invesmentmodeling.calculators;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

public class CalcCapRate implements Calculator {

    double estMaintenanceRate = 0.10;   // Should be 10% to 15% of rents

    // TODO: Pass property class and allow for another way which is to pass the net income
    @Override
    public double calc(Object o) {
        Property property = (Property) o;
        return property.getAnnualNetIncome() /
                (property.getTakeOutCost() + property.getPurchasePrice() +
                        property.getRehab());
    }


    public double calcWithMaintenance(Property property) {

        return (property.getAnnualNetIncome() - (property.getRent() * 12 * estMaintenanceRate) /
                (property.getTakeOutCost() + property.getPurchasePrice() +
                        property.getRehab()));

    }


    public void setEstMaintenanceRate(double estMaintenanceRate) {
        this.estMaintenanceRate = estMaintenanceRate;
    }
}
