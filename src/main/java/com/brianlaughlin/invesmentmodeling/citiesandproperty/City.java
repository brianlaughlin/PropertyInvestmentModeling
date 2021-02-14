package com.brianlaughlin.invesmentmodeling.citiesandproperty;

import lombok.Data;

public abstract class City {
    public String name;
    public Double taxRate;
    public String state;
    public Double investmentReturnMinimum;
    public Double defaultRehab; // To accomodate unknown rehab amounts

}
