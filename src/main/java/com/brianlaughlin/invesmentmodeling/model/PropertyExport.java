package com.brianlaughlin.invesmentmodeling.model;

import lombok.Data;

@Data
public class PropertyExport {

    String street;
    String city;
    String zipcode;
    Double purchasePrice;
    Double rehab;
    Double rent;
    Double cashOnCashReturn;
    Double estARV;
    Double takeOutCost;
    Double TOIPercentage;
    String status;

}
