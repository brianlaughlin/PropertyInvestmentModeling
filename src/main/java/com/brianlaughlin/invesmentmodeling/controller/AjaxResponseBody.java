package com.brianlaughlin.invesmentmodeling.controller;

import lombok.Data;

import java.util.List;

@Data
public class AjaxResponseBody {

    String msg;
    List<User> result;

    //getters and setters

}