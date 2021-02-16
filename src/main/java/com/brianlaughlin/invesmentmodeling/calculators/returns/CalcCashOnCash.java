package com.brianlaughlin.invesmentmodeling.calculators.returns;

import com.brianlaughlin.invesmentmodeling.calculators.Calculator;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

public class CalcCashOnCash implements Calculator {

    Property property;

    @Override
    public double calc(Object o) {
        property = (Property) o;

        return getCashOnCash();
    }

    private double getCashOnCash() {
        double annualIncome = property.getRent() * 12;
        double cashInvestment = property.getPurchasePrice() - property.getLoanAmount();

        return annualIncome / cashInvestment;
    }
}
