package com.brianlaughlin.invesmentmodeling.calculators.rehab;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.RehabState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcRehabTest {
    Property p;

    @Before
    public void setUp() {
        p = new Property("Detroit", "123 Testing",
                "48234", 750.0, 0.08, 27000.0, RehabState.LIGHT, 668);
    }

    @Test
    public void calcUnder1500() {
        CalcRehab rehabCalculator = new CalcRehab();
        rehabCalculator.calc(p);
        Assert.assertEquals(10000.0, rehabCalculator.calc(p), 0.001);

        p.setRehabState(RehabState.AVERAGE);
        Assert.assertEquals(25000.0, rehabCalculator.calc(p), 0.001);

        p.setRehabState(RehabState.HEAVY);
        Assert.assertEquals(50000.0, rehabCalculator.calc(p), 0.001);
    }

    @Test
    public void calc1500to25000() {
        p.setInteriorSqft(1600);

        CalcRehab rehabCalculator = new CalcRehab();
        rehabCalculator.calc(p);
        Assert.assertEquals(15000.0, rehabCalculator.calc(p), 0.001);

        p.setRehabState(RehabState.AVERAGE);
        Assert.assertEquals(35000.0, rehabCalculator.calc(p), 0.001);

        p.setRehabState(RehabState.HEAVY);
        Assert.assertEquals(75000.0, rehabCalculator.calc(p), 0.001);
    }

}