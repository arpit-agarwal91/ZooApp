package com.zoo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class IndexController implements ErrorController{
    private final static String PATH = "/error";
    @Override
    @RequestMapping(PATH)
    public @ResponseBody String getErrorPath() {
        // TODO Auto-generated method stub
        return "No Mapping Found";
    }

}