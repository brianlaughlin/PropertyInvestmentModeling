package com.brianlaughlin.invesmentmodeling.calculators.rehab;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.status.RehabStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcRehabTest {
    Property p;

    @Before
    public void setUp() {
        p = new Property("Detroit", "123 Testing",
                "48234", 750.0, 0.08, 27000.0, RehabStatus.LIGHT, 668);
    }

    @Test
    public void calcUnder1500() {
        CalcRehab rehabCalculator = new CalcRehab();
        rehabCalculator.calc(p);
        Assert.assertEquals(10000.0, rehabCalculator.calc(p), 0.001);
        compareRehabMethods(rehabCalculator);

        p.setRehabStatus(RehabStatus.AVERAGE);
        Assert.assertEquals(25000.0, rehabCalculator.calc(p), 0.001);
        compareRehabMethods(rehabCalculator);

        p.setRehabStatus(RehabStatus.HEAVY);
        Assert.assertEquals(50000.0, rehabCalculator.calc(p), 0.001);
        compareRehabMethods(rehabCalculator);
    }

    private void compareRehabMethods(CalcRehab rehabCalculator) {
        System.out.println("Mac Major estimates are: " + rehabCalculator.calcMacMajor() + " vs " + rehabCalculator.calc(p));
    }

    @Test
    public void calc1500to25000() {
        p.setInteriorSqft(1600);

        CalcRehab rehabCalculator = new CalcRehab();
        rehabCalculator.calc(p);
        Assert.assertEquals(15000.0, rehabCalculator.calc(p), 0.001);
        compareRehabMethods(rehabCalculator);

        p.setRehabStatus(RehabStatus.AVERAGE);
        Assert.assertEquals(35000.0, rehabCalculator.calc(p), 0.001);
        compareRehabMethods(rehabCalculator);

        p.setRehabStatus(RehabStatus.HEAVY);
        Assert.assertEquals(75000.0, rehabCalculator.calc(p), 0.001);
        compareRehabMethods(rehabCalculator);
    }

}