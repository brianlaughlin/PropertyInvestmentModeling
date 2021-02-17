package com.brianlaughlin.invesmentmodeling.calculators.value;

import com.brianlaughlin.invesmentmodeling.calculators.Calculator;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import lombok.Data;

/*
Income approach uses Annual net income / market cap rate = property value
 */

@Data
public class IncomeApproach implements Calculator {
    Double capRate = 0.05;
    Property property;

    @Override
    public double calc(Object o) {
        return incomeApproachValue((Property) o, capRate);
    }

    public double calcWithCapRate(Object o, double capRate){
        this.capRate = capRate;
        return incomeApproachValue((Property) o, capRate);
    }

    private double incomeApproachValue(Property o, double capRate) {
        property = o;
        return o.getAnnualNetIncome() / capRate;
    }
}
