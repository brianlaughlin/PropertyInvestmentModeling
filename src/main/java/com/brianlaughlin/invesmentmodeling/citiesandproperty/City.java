package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import lombok.Data;

public abstract class City {
    String name;
    Double taxRate;
    String state;
    Double investmentReturnMinimum;
    Double defaultRehab; // To accomodate unknown rehab amounts

}
