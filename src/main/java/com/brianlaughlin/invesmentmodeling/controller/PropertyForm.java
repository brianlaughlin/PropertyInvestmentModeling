package com.brianlaughlin.invesmentmodeling.controller;

import com.brianlaughlin.invesmentmodeling.citiesandproperty.Property;
import com.brianlaughlin.invesmentmodeling.domain.Portfolio;
import com.brianlaughlin.invesmentmodeling.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PropertyForm {

//    @Autowired
//    private PropertyForm propertyForm;

    private final PortfolioRepository portfolioRepository;

    public PropertyForm(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }


    @RequestMapping(value ="/form")
    public String mainForm(Model model){
        model.addAttribute("portfolio", new Portfolio());
        return "form";
    }

    @RequestMapping(value = "ajax")
    public String ajax(){
        return "ajax";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Portfolio portfolio, Model model){

       portfolioRepository.save(portfolio);
        return "redirect:/";
    }

}
