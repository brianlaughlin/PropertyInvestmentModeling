package com.brianlaughlin.invesmentmodeling.calculators;

//https://poi.apache.org/apidocs/dev/org/apache/poi/ss/formula/functions/Irr.html
import org.apache.poi.ss.formula.functions.Irr;

/*
The library is so complete I don't think I need to do much here. I should just add this functionality to another class.
TODO: add this call to another class
 */
public class IrrCalculatorTest {

    public static void main(String[] args) {


        double[] investmentNumbers = new double[11];
        investmentNumbers[0] = -10000000.0;
        investmentNumbers[1] = 550000.0;
        investmentNumbers[2] = 566500.0;
        investmentNumbers[3] = 583495.0;
        investmentNumbers[4] = 601000.0;
        investmentNumbers[5] = 619030.0;
        investmentNumbers[6] = 637601.0;
        investmentNumbers[7] = 656729.0;
        investmentNumbers[8] = 676431.0;
        investmentNumbers[9] = 696724.0;
        investmentNumbers[10] = 18717625.0;

        System.out.println(Irr.irr(investmentNumbers));


    }
}
