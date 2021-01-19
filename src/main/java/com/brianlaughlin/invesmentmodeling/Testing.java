package com.brianlaughlin.invesmentmodeling;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.csv.CsvPropertyWriter;
import com.brianlaughlin.invesmentmodeling.model.LoadRealProperties;
import com.brianlaughlin.invesmentmodeling.model.PropertyExport;
import com.brianlaughlin.invesmentmodeling.model.PropertySave;
import org.apache.tomcat.util.digester.ArrayStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Testing {
    public static void main(String[] args) {

//        new FourthTest().invoke();

//        printSeparator("Random property generation");


        new RealPropertyTest().invoke();
        printSeparator("With Loans");

        new RealPropertyTest().propertiesWithLoans();

        // Testing PropertyExport
        printSeparator("Testing PropertyExport Class");

        try {
            new PropertyExportTest().invoke();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void printSeparator(String mesg) {
        System.out.println("____________________" + mesg + "____________________");
    }


    private static class ShowProperties {
        private List<Property> properties;
        private List<PropertyExport> propertyExports;

        public ShowProperties(List<Property> properties) {
            this.properties = properties;
        }

        // String is so I can have a unique constructor
        public ShowProperties(List<PropertyExport> propertyExports, String listName)
        {
            this.propertyExports = propertyExports;
        }


        public void show() {


            if (properties!=null) {
                for (Property p : properties) {
                    System.out.println("Purchase price: " + p.getPurchasePrice() +
                            " Cash on cash return: " + p.getCashOnCashReturn() + "  Rating: " +
                            p.isExpectedInvestmentMinAchieved() + " TOI % " + p.getInvestorTakeOutRate()
                            + " Rent: " + p.getRent() + " with a rent multiplier of " + p.getRentMultiplier());
                    System.out.println(p);
                }
            } else {
                for (PropertyExport p : propertyExports) {
                    System.out.println("Purchase price: " + p.getPurchasePrice() +
                            " Cash on cash return: " + p.getCashOnCashReturn() + "  Rating: " +
                            " TOI % " + p.getToiPercentage()
                            + " Rent: " + p.getRent() + " with a rent multiplier of ");
                    System.out.println(p);
                }
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

        public void propertiesWithLoans(){
            loadRealProperties = new LoadRealProperties();
            properties.clear();
            properties = loadRealProperties.LoadRealPropertiesWithLoan();

            invoke();
        }

    }

    private static class PropertyExportTest {
        List<Property> properties = new ArrayStack<>();
        List<PropertyExport> propertyExport = new ArrayList<>();
        LoadRealProperties loadRealProperties;
        PropertySave propertySave;

        public PropertyExportTest() {
            this.loadRealProperties = new LoadRealProperties();
            this.properties = loadRealProperties.getProperties();
            propertySave = new PropertySave(properties, propertyExport);

        }

        public List<PropertyExport> convert(){

            propertyExport = propertySave.save();
            return propertyExport;
        }

        public void invoke() throws IOException {
//            ShowProperties showProperties;
//            new ShowProperties(convert(), "exportlist").show();

            CsvPropertyWriter writer = new CsvPropertyWriter("properties.csv", convert());
            writer.write();
            System.out.println("File written to drive");

        }
    }
}
