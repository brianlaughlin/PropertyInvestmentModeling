package com.brianlaughlin.invesmentmodeling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor  // Not sure if I need this
public class PropertyExport {

    String street;
    String city;
    String zipcode;
    Double purchaseprice;
    Double rehab;
    Double rent;
    Double cashoncashreturn;
    Double estarv;
    Double takeoutcost;
    Double toipercentage;
    String status;

}
