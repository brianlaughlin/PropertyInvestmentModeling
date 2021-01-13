package com.brianlaughlin.invesmentmodeling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyForm {

//    @Autowired
//    private PropertyForm propertyForm;

    @RequestMapping(value ="/form")
    public String mainForm(){

        return "form";
    }

    @RequestMapping(value = "ajax")
    public String ajax(){
        return "ajax";
    }
}
