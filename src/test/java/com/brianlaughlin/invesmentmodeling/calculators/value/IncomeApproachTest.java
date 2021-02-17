package com.brianlaughlin.invesmentmodeling.calculators.value;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.RehabState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IncomeApproachTest {

    Property p;

    @Before
    public void setUp() throws Exception {
        p = new Property("Detroit", "123 Testing",
                "48234", 750.0, 0.08, 27000.0, RehabState.LIGHT, 668);

    }

    @Test
    public void calc() {
        IncomeApproach incomeApproach = new IncomeApproach();

        Assert.assertEquals(151074.0, incomeApproach.calc(p), 0.001);
        System.out.println(incomeApproach.calc(p));

    }

    @Test
    public void calcWithCapRate() {
        IncomeApproach incomeApproach = new IncomeApproach();

        Assert.assertEquals(75537.0, incomeApproach.calcWithCapRate(p, 0.10), 0.001);
        System.out.println(incomeApproach.calcWithCapRate(p, 0.10));

    }
}