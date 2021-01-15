package com.brianlaughlin.invesmentmodeling;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.model.LoadRealProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Testing {
    public static void main(String[] args) {

//        new FourthTest().invoke();

//        printSeparator("Random property generation");

        new RealPropertyTest().invoke();

    }

    private static void printSeparator(String mesg) {
        System.out.println("____________________" + mesg + "____________________");
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
                        + " Rent: " + p.getRent() + " with a rent multiplier of " + p.getRentMultiplier());
                System.out.println(p);
            }
        }
    }

    private static class FourthTest {
        private List<Property> properties = new ArrayList<>();
        Random rand = new Random();
        Double minRentMultiplier = 10.0;

        public void invoke() {
            int n = 0;
            int counter = 0;
            while (n < 1000) {
                Property p = new Property("Jacksonville");
                p.setPurchasePrice(rand.nextInt(110000) + 30000.0);
                p.setRehab(rand.nextInt(30000) + 1.0);
                p.setPropertyManagementRate((rand.nextInt(5) + 6.0) / 100);
                int rentMultiplier = rand.nextInt(10);
                Double rm = (rentMultiplier / 1000.0) + 0.01;
                p.setRent(p.getPurchasePrice() * rm);

                // Add an address
                p.makeUpAddress();
                counter++;
                if (p.isExpectedInvestmentMinAchieved()) {
                    properties.add(p);
                    System.out.println("Found one!");
                    System.out.println(p.getCashOnCashReturn());
                    n++;

                    if (p.getRentMultiplier() < minRentMultiplier) minRentMultiplier = p.getRentMultiplier();
                }

                ShowProperties showProperties;
                new ShowProperties(properties).show();

                System.out.println("Total properties simulated was " + counter);
                System.out.println("The min Rent Multiplier is: " + minRentMultiplier);
            }
        }
    }

    private static class RealPropertyTest {
        LoadRealProperties loadRealProperties;
        List<Property> properties;

        public RealPropertyTest(){
                loadRealProperties = new LoadRealProperties();
                this.properties = loadRealProperties.getProperties();
        }

        public void invoke(){
            ShowProperties showProperties;
            new ShowProperties(properties).show();



        }

    }
}
