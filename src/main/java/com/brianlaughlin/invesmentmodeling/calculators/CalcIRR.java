package com.brianlaughlin.invesmentmodeling.calculators;

import org.apache.poi.ss.formula.functions.Irr;

public class CalcIRR implements Calculator {
    @Override
    public double calc(Object o) {
        return Irr.irr((double[]) o);
    }
}
