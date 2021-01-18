package com.brianlaughlin.invesmentmodeling.model;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;

import java.util.List;

public class PropertySave {
    List<Property> properties;
    List<PropertyExport> propertyExports;

    public PropertySave(List<Property> properties, List<PropertyExport> propertyExports) {
        this.properties = properties;
        this.propertyExports = propertyExports;
    }

    public List<PropertyExport> save() {
        for (Property p : properties) {
            PropertyExport pe = new PropertyExport();
            pe.setStreet(p.getStreet());
            pe.setCity(p.getCityName());
            pe.setZipcode(p.getZipcode());
            pe.setPurchasePrice(p.getPurchasePrice());
            pe.setRehab(p.getRehab());
            pe.setRent(p.getRent());
            pe.setCashOnCashReturn(p.getCashOnCashReturn());
            pe.setEstARV(p.getEstARV());
            pe.setTakeOutCost(p.getTakeOutCost());
            pe.setTOIPercentage(p.getInvestorTakeOutRate());
            pe.setStatus(String.valueOf(p.getStatus()));

        }

        return propertyExports;
    }

}
