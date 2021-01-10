package com.brianlaughlin.invesmentmodeling;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {

        Property property = new Property("Detroit", 40000.00);

        System.out.println("Property tax in " + property.getCityName() + " is "
                + property.getPropertyTaxYearly() + "/yr");

        System.out.println(property.toString());

        Property jacksonvilleTest = new Property("Jacksonville", 75000.00);

        jacksonvilleTest.setRent(1650.00);
        jacksonvilleTest.setPropertyManagementRate(0.08);
        jacksonvilleTest.setLoanAmount(0.0);
        jacksonvilleTest.setRehab(6000.00);

        NumberFormat defaultNumberFormat = NumberFormat.getCurrencyInstance();


        System.out.println("_________________________________________");
        System.out.println("Total expenses : " + defaultNumberFormat.format(jacksonvilleTest.getTotalMonthlyExpense()));
        System.out.println("Annual Income : " + defaultNumberFormat.format(jacksonvilleTest.getAnnualIncome()));
        System.out.println("Cash on cash return : " + jacksonvilleTest.getCashOnCashReturn());
        System.out.println("Propety meets investment requirement : " + jacksonvilleTest.isExpectedInvestmentMinAchieved());

        List<Property> propeties = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
          Property p = new Property("Jacksonville");
        }
    }

}
