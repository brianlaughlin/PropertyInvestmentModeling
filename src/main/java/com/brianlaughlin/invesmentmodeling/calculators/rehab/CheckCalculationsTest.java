package com.brianlaughlin.invesmentmodeling.calculators.rehab;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.status.RehabStatus;


public class CheckCalculationsTest {
    static Property p;

    public static void main(String[] args) {

        checkRehab();

    }

    static void checkRehab() {
        p = new Property("Jacksonville", "304 Goodwin St", "32204", 900.0, 0.08, 47000.0, RehabStatus.AVERAGE, 780);

        CalcRehab calcRehab = new CalcRehab();
        System.out.println("Average rehab " + calcRehab.calc(p));

        p.setRehabStatus(RehabStatus.LIGHT);
        System.out.println("Light rehab : " + calcRehab.calc(p));

    }

}
