package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import com.brianlaughlin.invesmentmodeling.faker.StreetNameGenerator;
import lombok.Data;

@Data
public class Property {
    String street;
    String zipcode;
    Double rent = 0.0;
    Double propertyManagementRate = 0.1;
    Double loanAmount = 0.0;
    Double rehab = 0.0;
    Double deferedMaintenance = 0.0;
    Double vacancyRate = 0.0;

    City city;

    Double purchasePrice;
    String notes;
    Integer neighborhoodRating;

    Double estimatedTakeoutExpenseRate = 0.10;

    Double annualIncome = 0.0;
    Double monthlyNetIncome = 0.0;
    Double cashOnCashReturn = 0.0;


    public Double getTotalMonthlyExpense() {
        // TODO: FINISH THE FORMULA
        // property tax + hoa + loan payment + property mgt fee

        return getPropertyTaxMontly() + (getPropertyManagementRate() * rent);
    }

    Double totalMonthlyExpense;


    public Property(String cityName, Double purchasePrice) {
        this.purchasePrice = purchasePrice;
        switch (cityName) {
            case "Detroit":
                this.city = new Detroit();
                break;
            case "Jacksonville":
                this.city = new Jacksonville();
                break;
        }

        makeUpAddress();
    }

    public Double getPropertyTaxYearly() {
        return city.taxRate * purchasePrice;
    }

    public Double getPropertyTaxMontly() {
        return city.taxRate * purchasePrice / 12;
    }

    public String getCityName() {
        return city.name;
    }

    private void makeUpAddress() {
        this.street = StreetNameGenerator.generateAddress();
    }

    public Double getAnnualIncome() {

        return getMonthlyNetIncome() * 12;
    }

    public Double getMonthlyNetIncome() {

        return rent - getTotalMonthlyExpense();
    }

    public Double getDownpayment(){
        return purchasePrice - loanAmount;
    }

    public Double getCashOnCashReturn() {
        // Annual income / (repair cost + downpayment + take out expenses)
        return getAnnualIncome() / (rehab + getDownpayment() + (getEstimatedTakeoutExpenseRate() * purchasePrice));
    }
}
