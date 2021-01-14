package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertyTest {
    Property p;

    @Before
    public void setUp() {
        p = new Property("Jacksonville", 30000.0);
        p.setRent(800.0);
        p.setRehab(6000.00);
        p.setPropertyManagementRate(0.08);
    }


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

    @Test
    public void getTotalMonthlyExpense() {
        System.out.println(p.getTotalMonthlyExpense());
        System.out.println("Property Tax: " + p.getPropertyTaxMontly());
        System.out.println("HOA: " + p.getHoa());

        // this is a private field so I have  to do it manually.
        System.out.println("Loan Payment: " + p.loanAmount * p.interestRate / 12);
        System.out.println("Property Mgt Fee: " + p.getPropertyManagementRate() * p.rent);

        Assert.assertTrue((89.25 - p.getTotalMonthlyExpense() == 0));
        Assert.assertEquals(89.25, p.getTotalMonthlyExpense(), 0.001);
    }

    @Test
    public void getMonthlyNetIncome() {
        Assert.assertEquals(710.75, p.getMonthlyNetIncome(), 0.001);

    }

    @Test
    public void getAnnualIncome(){
        Assert.assertEquals(8529.0, p.getAnnualIncome(), 0.001);
    }

    @Test
    public void getDownpayment(){
        System.out.println("Purchase price - loan amount");
        Assert.assertEquals(30000.0, p.getDownpayment(), 0.001);
    }

    @Test
    public void getEstimatedTakeoutExpenses(){
        System.out.println("EstimatedTakeoutExpenseRate * (purhcase price + rehab))");
        Assert.assertEquals(3600.0, (p.estimatedTakeoutExpenseRate* (p.purchasePrice + p.rehab)), 0.001);
    }
}
