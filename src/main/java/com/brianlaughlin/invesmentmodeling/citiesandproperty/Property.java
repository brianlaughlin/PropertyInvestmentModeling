package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import com.brianlaughlin.invesmentmodeling.faker.StreetNameGenerator;
import lombok.Data;

@Data
public class Property extends Cities {
    static final Double INVESTOR_PERCENTAGE = 0.75; // 75%
    static final Double TEAM_PERCENTAGE = 0.25; // 25%

    // Location
    String street;
    String zipcode;
    String notes;
    Integer neighborhoodRating;

    // Financials
    Double rent = 0.0;
    Double propertyManagementRate = 0.1;
    Double loanAmount = 0.0;
    Double rehab = 0.0;
    Double deferedMaintenance = 0.0;
    Double vacancyRate = 0.0;
    Double hoa = 0.0;
    Double interestRate = 0.08; // 8%
    Double purchasePrice = 0.0;
    Double estARV = 0.0;

    Double estimatedTakeoutExpenseRate = 0.10;

    // Calculated Returns
    Double annualIncome = 0.0;
    Double monthlyNetIncome = 0.0;
    Double cashOnCashReturn = 0.0;

    Double totalMonthlyExpense = 0.0;

    Double takeOutInvestorRate = 0.0;
    Double takeOutCost = 0.0;
    Double padPercentage = 0.10;

    Double rentMultiplier = 0.0; // Rent ratio compared to purchase price


    public Property(String cityName, Double purchasePrice) {
        this.purchasePrice = purchasePrice;
        setCityClassByName(cityName);

        makeUpAddress();
    }

    public Property(String cityName, String street, String zipcode, Double rent, Double propertyManagementRate, Double rehab, Double purchasePrice) {
        setCityClassByName(cityName);
        this.street = street;
        this.zipcode = zipcode;
        this.rent = rent;
        this.propertyManagementRate = propertyManagementRate;
        this.rehab = rehab;
        this.purchasePrice = purchasePrice;
    }

    public Property(String cityName) {
        setCityClassByName(cityName);
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

    public void makeUpAddress() {
        this.street = StreetNameGenerator.generateAddress();
    }

    public Double getAnnualIncome() {
        return getMonthlyNetIncome() * 12;
    }

    public Double getMonthlyNetIncome() {

        return rent - getTotalMonthlyExpense();
    }

    public Double getDownpayment() {
        return purchasePrice - loanAmount;
    }

    public Double getCashOnCashReturn() {

        return getAnnualIncome() / (rehab + getDownpayment() + (estimatedTakeoutExpenseRate * (purchasePrice + rehab)));
    }

    public Double getTotalMonthlyExpense() {

        return getPropertyTaxMontly() + hoa + getLoanPayment() + (getPropertyManagementRate() * rent);
    }

    private Double getLoanPayment() {
        return loanAmount * interestRate / 12;
    }

    // Annual rent * 75% / Take ot cost
    public Double getInvestorTakeOutRate() {
        return (this.rent * 12) * INVESTOR_PERCENTAGE / getTakeOutCost();
    }

    public Boolean isExpectedInvestmentMinAchieved() {
        return city.investmentReturnMinimum <= getCashOnCashReturn();
    }

    public Double getTakeOutCost() {
        return (this.purchasePrice + this.rehab) * padPercentage;
    }

    public Double getRentMultiplier() {
        return rent / purchasePrice;
    }
}
