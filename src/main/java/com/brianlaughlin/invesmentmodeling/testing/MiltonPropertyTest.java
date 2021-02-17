package com.brianlaughlin.invesmentmodeling.testing;

import com.brianlaughlin.invesmentmodeling.calculators.returns.CalcCashOnCash;
import com.brianlaughlin.invesmentmodeling.calculators.returns.CalcReturnOnEquity;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

public class MiltonPropertyTest {
    public static void main(String[] args) {
        Property property = new Property("Santa Ana","4th St", "92701", 1550.0,0.08,0.0,120000.0);
        property.setCurrentValue(375000.0);

        CalcCashOnCash calcCashOnCash = new CalcCashOnCash();
        System.out.println("Cash on Cash : " + calcCashOnCash.calc(property));

        CalcReturnOnEquity returnOnEquity = new CalcReturnOnEquity();
        System.out.println("Return on Equity: " + returnOnEquity.calc(property));
    }
}
