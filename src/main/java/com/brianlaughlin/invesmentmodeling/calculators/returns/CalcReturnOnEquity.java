package com.brianlaughlin.invesmentmodeling.calculators.returns;

import com.brianlaughlin.invesmentmodeling.calculators.Calculator;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

public class CalcReturnOnEquity implements Calculator {

    Property p;

    @Override
    public double calc(Object o) {
        p = (Property) o;
        return p.getAnnualNetIncome() / p.getCurrentValue();
    }
}
