package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.status.MarketStatus;
import com.brianlaughlin.invesmentmodeling.citiesandproperty.status.RehabStatus;
import com.brianlaughlin.invesmentmodeling.faker.StreetNameGenerator;
import lombok.Data;

@Data
public class Property extends Cities {
    public final Location location = new Location();

    static final Double INVESTOR_PERCENTAGE = 0.75; // 75%
    static final Double TEAM_PERCENTAGE = 0.25; // 25%

    // Misc
    String notes;


    // Financials
    Double rent = 0.0;
    Double propertyManagementRate = 0.1;
    Double loanAmount = 0.0;
    Double rehab = 0.0;
    Double deferedMaintenance = 0.0;
    Double vacancyRate = 0.0;
    Double hoa = 0.0;
    Double interestRate = 0.085; // 8.5%
    Double purchasePrice = 0.0;
    Double estARV = 0.0;
    Double estimatedTakeoutExpenseRate = 0.10;
    Double padPercentage = 0.10;
    Double rentMultiplier = 0.0; // Rent ratio compared to purchase price
    Double currentValue = 0.0; // this can be different from purchase price. One example would be looking at a property
                                // years later.

    Double cashOnCashReturnIncludingDepreciation = 0.0;

    // Features
    int interiorSqft = 0;

    MarketStatus marketStatus;
    RehabStatus rehabStatus;

    // Expenses
    // todo: start to consider what utilities owner might be responsible for. Consider how to represeent this in a class

    public Property(String cityName, Double purchasePrice) {
        this.purchasePrice = purchasePrice;
        setCityClassByName(cityName);

        makeUpAddress();
    }

    public Property(String cityName, String street, String zipcode, Double rent, Double propertyManagementRate,
                    Double rehab, Double purchasePrice) {
        setCityClassByName(cityName);
        this.location.setStreet(street);
        this.location.setZipcode(zipcode);
        this.rent = rent;
        this.propertyManagementRate = propertyManagementRate;
        this.rehab = rehab;
        this.purchasePrice = purchasePrice;
    }

    // Use for constrction rehab estimates
    public Property(String cityName, String street, String zipcode, Double rent, Double propertyManagementRate,
                    Double purchasePrice, RehabStatus rehabStatus, int interiorSqft) {
        setCityClassByName(cityName);
        this.location.setStreet(street);
        this.location.setZipcode(zipcode);
        this.rent = rent;
        this.propertyManagementRate = propertyManagementRate;
        this.purchasePrice = purchasePrice;
        this.rehabStatus = rehabStatus;
        this.interiorSqft = interiorSqft;
    }

    public Property(String cityName, String street, String zipcode, Double rent,
                    Double propertyManagementRate, Double rehab, Double purchasePrice,
                    MarketStatus marketStatus) {
        setCityClassByName(cityName);
        this.location.setStreet(street);
        this.location.setZipcode(zipcode);
        this.rent = rent;
        this.propertyManagementRate = propertyManagementRate;
        this.rehab = rehab;
        this.purchasePrice = purchasePrice;
        this.marketStatus = marketStatus;
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
        this.location.setStreet(StreetNameGenerator.generateAddress());
    }

    public Double getAnnualIncome() {
        return getMonthlyNetIncome() * 12;
    }

    public Double getMonthlyNetIncome() {

        return rent - getTotalMonthlyExpense();
    }

    public Double getAnnualNetIncome(){

        return getMonthlyNetIncome() * 12;
    }

    public Double getDownpayment() {
        return purchasePrice - loanAmount;
    }

    public Double getCashOnCashReturn() {

        return getAnnualIncome() / (rehab + getDownpayment() + (estimatedTakeoutExpenseRate * (purchasePrice + rehab)));
    }

    public Double getCashOnCashReturnIncludingDepreciation() {

        return (getAnnualIncome() + getAnnualDepreciation()) / (rehab + getDownpayment() + (estimatedTakeoutExpenseRate * (purchasePrice + rehab)));
    }

    public Double getTotalMonthlyExpense() {

        return getPropertyTaxMontly() + hoa + getLoanPayment() + (getPropertyManagementRate() * rent);
    }

    private Double getLoanPayment() {
        return loanAmount * interestRate / 12;
    }

    // Cash on Cash * 75% (Investor Percentage)
    public Double getInvestorTakeOutRate() {
        return getCashOnCashReturn() * INVESTOR_PERCENTAGE;
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

    // purchase price / 2 (for improvement value) / 27.5 years
    public Double getAnnualDepreciation() {
        return purchasePrice / 2 / 27.5;
    }

    public Double getAnnualDepreciationInvestorShare() {
        return getAnnualDepreciation() * INVESTOR_PERCENTAGE;
    }
}
