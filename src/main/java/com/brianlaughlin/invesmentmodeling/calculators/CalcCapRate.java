package com.brianlaughlin.invesmentmodeling.calculators;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

public class CalcCapRate implements Calculator {

    double estMaintenanceRate = 0.10;   // Should be 10% to 15% of rents

    @Override
    public double calc(Object o) {
        Property property = (Property) o;
        return property.getAnnualNetIncome() /
                getInvestment(property);
    }

    /**
     * <p>Internal method to help simplify code in calculating property investment</p>
     * @param property
     * @return
     */
    private double getInvestment(Property property) {
        return property.getTakeOutCost() + property.getPurchasePrice() +
                property.getRehab();
    }

    /**
     * <p>Cap Rate calculation that taks into account on-going maintenance costs.</p>
     * <i>It's typical to estiamte around 10 to 15 percent of monthly rents as deferred maintenance costs.</i>
     * <b>This will be a more conservative estimate.</b>
     * @param property
     * @return
     */
    public double calcWithMaintenance(Property property) {

        return ((property.getAnnualNetIncome() - (property.getRent() * 12 * estMaintenanceRate)) /
                (getInvestment(property)));

    }

    public void setEstMaintenanceRate(double estMaintenanceRate) {
        this.estMaintenanceRate = estMaintenanceRate;
    }
}
