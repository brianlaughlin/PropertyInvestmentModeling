package com.brianlaughlin.invesmentmodeling.calculators.rehab;

import com.brianlaughlin.invesmentmodeling.calculators.Calculator;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.status.RehabStatus;

public class CalcRehab implements Calculator {

    Property property;

    @Override
    public double calc(Object o) {
        property = (Property) o;

        return checkRehabEstimate(property.getInteriorSqft(), property.getRehabStatus());
    }

    private Double checkRehabEstimate(int interiorSqft, RehabStatus rehabStatus) {
        double result = 0.0;
        switch (rehabStatus) {
            case LIGHT:
                if (interiorSqft <= 1500) result = 10000.0;
                if (interiorSqft >= 1500 & interiorSqft < 2500) result = 15000.0;
                if (interiorSqft >= 2500 & interiorSqft < 3500) result = 25000.0;
                if (interiorSqft >= 3500 & interiorSqft < 5000) result = 30000.0;
                if (interiorSqft >= 5001) result = 40000.0;
                break;
            case AVERAGE:
                if (interiorSqft <= 1500) result = 25000.0;
                if (interiorSqft >= 1500 & interiorSqft < 2500) result = 35000.0;
                if (interiorSqft >= 2500 & interiorSqft < 3500) result = 45000.0;
                if (interiorSqft >= 3500 & interiorSqft < 5000) result = 55000.0;
                if (interiorSqft >= 5001) result = 70000.0;
                break;
            case HEAVY:
                if (interiorSqft <= 1500) result = 50000.0;
                if (interiorSqft >= 1500 & interiorSqft < 2500) result = 75000.0;
                if (interiorSqft >= 2500 & interiorSqft < 3500) result = 95000.0;
                if (interiorSqft >= 3500 & interiorSqft < 5000) result = 100000.0;
                if (interiorSqft >= 5001) result = 120000.0;
                break;
            default:
                result = 0.0;
        }

        return result;
    }

    // Estimates provided by Mac Major
    public Double calcMacMajor() {
        double result;

        switch (property.getRehabStatus()){
            case LIGHT:
                result = 20.0 * property.getInteriorSqft();
                break;
            case AVERAGE:
                result = 30.0 * property.getInteriorSqft();
                break;
            case HEAVY:
                result = 35.0 * property.getInteriorSqft();
                break;
            default:
                result = 0.0;
        }
        return result;
    }
}
