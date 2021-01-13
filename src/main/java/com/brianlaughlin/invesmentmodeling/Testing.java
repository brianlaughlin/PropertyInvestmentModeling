package com.brianlaughlin.invesmentmodeling;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.faker.StreetNameGenerator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//TODO: getAnnualIncome will give a negative result at times. Need to fix this.

public class Testing {
    public static void main(String[] args) {

        FirstTest firstTest = new FirstTest().invoke();

        Property jacksonvilleTest = firstTest.getJacksonvilleTest();
        NumberFormat defaultNumberFormat = firstTest.getDefaultNumberFormat();
        printSeparator("First Test");

//        List<Property> properties = new SecondTest(jacksonvilleTest, defaultNumberFormat).invoke();
//        new ShowProperties(properties).show();
//        printSeparator("Second Test");

        new FourthTest().invoke();

        printSeparator("DONE");
    }

    private static void printSeparator(String mesg) {
        System.out.println("____________________"+mesg+"____________________");
    }

    private static class FirstTest {
        private Property jacksonvilleTest;
        private NumberFormat defaultNumberFormat;

        public Property getJacksonvilleTest() {
            return jacksonvilleTest;
        }

        public NumberFormat getDefaultNumberFormat() {
            return defaultNumberFormat;
        }

        public FirstTest invoke() {
            Property property = new Property("Detroit", 40000.00);

            System.out.println("Property tax in " + property.getCityName() + " is "
                    + property.getPropertyTaxYearly() + "/yr");

            System.out.println(property.toString());

            jacksonvilleTest = new Property("Jacksonville", 30000.00);

            jacksonvilleTest.setRent(300.00);
            jacksonvilleTest.setPropertyManagementRate(0.08);
            jacksonvilleTest.setLoanAmount(0.0);
            jacksonvilleTest.setRehab(6000.00);

            defaultNumberFormat = NumberFormat.getCurrencyInstance();
            return this;
        }
    }

    private static class SecondTest {
        private Property jacksonvilleTest;
        private NumberFormat defaultNumberFormat;

        public SecondTest(Property jacksonvilleTest, NumberFormat defaultNumberFormat) {
            this.jacksonvilleTest = jacksonvilleTest;
            this.defaultNumberFormat = defaultNumberFormat;
        }

        public List<Property> invoke() {
            System.out.println("Total expenses : " + defaultNumberFormat.format(jacksonvilleTest.getTotalMonthlyExpense()));
            System.out.println("Annual Income : " + defaultNumberFormat.format(jacksonvilleTest.getAnnualIncome()));
            System.out.println("Cash on cash return : " + jacksonvilleTest.getCashOnCashReturn());
            System.out.println("Property meets investment requirement : " + jacksonvilleTest.isExpectedInvestmentMinAchieved());

            Double purchasePrice = 30000.00;
            List<Property> properties = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                Property p = new Property("Jacksonville");
                p.setPurchasePrice(purchasePrice);
                p.setRehab(6000.00);
                p.setPropertyManagementRate(0.08);
                p.setRent(750.0);

                // Add an address
                p.setStreet(StreetNameGenerator.generateAddress());
                properties.add(p);

                purchasePrice = purchasePrice + 5000.00;
            }
            return properties;
        }
    }

    private static class ShowProperties {
        private List<Property> properties;

        public ShowProperties(List<Property> properties) {
            this.properties = properties;
        }

        public void show() {
            for (Property p : properties) {
                System.out.println("Purchase price: " + p.getPurchasePrice() +
                        " Cash on cash return: " + p.getCashOnCashReturn() + "  Rating: " +
                        p.isExpectedInvestmentMinAchieved() + " TOI % " + p.getInvestorTakeOutRate()
                        + " Rent: " + p.getRent());
            }
        }
    }

    private static class FourthTest {
        private List<Property> properties = new ArrayList<>();
        Random rand = new Random();

        public void invoke() {
            int n = 0;
            int counter = 0;
            while (n < 1000) {
                Property p = new Property("Jacksonville");
                p.setPurchasePrice(rand.nextInt(110000) + 30000.0);
                p.setRehab(rand.nextInt(30000) + 1.0);
                p.setPropertyManagementRate(rand.nextInt(5) + 6.0);
//                p.setRent(rand.nextInt(1500) + 600.0);
                int rentMultiplier = rand.nextInt(6);
                Double rm = (rentMultiplier / 1000.0) + 0.014;
                System.out.println(rm);
                p.setRent(p.getPurchasePrice() * rm);

                // Add an address
                p.makeUpAddress();
                counter++;
//                if(p.isExpectedInvestmentMinAchieved())
//                {
                    properties.add(p);
//                    System.out.println("Found one!");
                System.out.println(p.getCashOnCashReturn());
                    n++;
//                }
//                System.out.println("Counter: " + counter + " and found: " + n);
            }


            ShowProperties showProperties;
            new ShowProperties(properties).show();
        }
    }
}
