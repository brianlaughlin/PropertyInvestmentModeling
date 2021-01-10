package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import org.junit.Assert;
import org.junit.Test;

public class PropertyTest {

    @Test
    public void testGetCashOnCashReturn() throws Exception {
        final double THRESHOLD = 0.0001;
        final Double ANSWER = 0.07598484848484849;

        Property p = new Property("Jacksonville", 30000.0);
        p.setRent(300.00);
        p.setPropertyManagementRate(0.08);
        p.setRehab(6000.00);

        System.out.println("Net monthly income: " + p.getMonthlyNetIncome());
        System.out.println("Take out exp: " + p.getTakeOutCost());
        System.out.println("Total expense: " + p.getTotalMonthlyExpense());
        System.out.println("Cash on Cash : " + p.getCashOnCashReturn());

        System.out.println("Annual income: " + p.getAnnualIncome());

        Double result = p.getCashOnCashReturn();

        Double compareEqual = Math.abs(result - ANSWER);
        Assert.assertTrue(compareEqual < THRESHOLD);
        Assert.assertEquals(ANSWER, result);
    }

}
