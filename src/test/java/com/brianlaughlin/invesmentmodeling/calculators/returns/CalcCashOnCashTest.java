package com.brianlaughlin.invesmentmodeling.calculators.returns;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcCashOnCashTest {
    Property p;
    CalcCashOnCash calcCashOnCash;

    @Before
    public void setUp() {
        p = new Property("Jacksonville", 120000.0);
        p.setRent(1550.0);
        calcCashOnCash = new CalcCashOnCash();
    }

    @Test
    public void testGrossCashOnCash() throws Exception {

        Assert.assertEquals(0.155, calcCashOnCash.calc(p), 0.001);
    }


}