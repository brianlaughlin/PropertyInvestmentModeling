package com.brianlaughlin.invesmentmodeling.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertyExport {

    String street;
    String city;
    String zipcode;
    Double purchasePrice;
    Double rehab;
    Double rent;
    Double cashOnCashReturn;
    Double estArv;
    Double takeoutCost;
    Double toiPercentage;
    String status;

}
