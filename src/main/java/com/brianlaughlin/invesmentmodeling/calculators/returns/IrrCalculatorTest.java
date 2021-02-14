package com.brianlaughlin.invesmentmodeling.calculators.returns;

//https://poi.apache.org/apidocs/dev/org/apache/poi/ss/formula/functions/Irr.html
import com.brianlaughlin.invesmentmodeling.calculators.Calculator;
import com.brianlaughlin.invesmentmodeling.calculators.returns.CalcCapRate;
import com.brianlaughlin.invesmentmodeling.calculators.returns.CalcIRR;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import org.apache.poi.ss.formula.functions.Irr;

public class IrrCalculatorTest {

    public static void main(String[] args) {


        irrTest1();

        System.out.println("4 Months of ownership");
        irrTestPartnerOwners();

        testNetIncome();
    }

    /*
    Testing IRR return
     */
    private static void irrTest1() {
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

        /*
        Using interface should return same result
         */
        Calculator c = new CalcIRR();
        System.out.println("This should be the same as above number " +
                c.calc(investmentNumbers));

    }
    /*
    Looking at what our IRR would be for our investments as partner owners
    4 months @ 600 + takeout (5000) + 25%
     */
    private static void irrTestPartnerOwners() {
        double[] investmentNumbers = new double[2];
        investmentNumbers[0] = -40000.0;
        investmentNumbers[1] = 57500.0;


        System.out.println(Irr.irr(investmentNumbers));
    }

    private static void testNetIncome(){
        Property property = new Property("Detroit", "15639 Fairmount Dr", "48205", 750.0, 0.08, 6500.0, 29000.0);
        CalcCapRate c = new CalcCapRate();
        System.out.println("Cap Rate: " + c.calc(property));

        System.out.println("Cap Rate with Maintenace: " + c.calcWithMaintenance(property));

    }

}
