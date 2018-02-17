package com.assingment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;

@Controller
public class SearchController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  private static final String DASHBOARD = "dashboard";

  private static final String ALL_EMPLOYEES_KEY = "allEmployees";

  @RequestMapping(value = "/search")
  public String search(
      @RequestParam(value = "searchTerm", required = false)
          String searchTerm,
      @RequestParam(value = "gender", required = false)
          String gender,
      @RequestParam(value = "age", required = false)
          String age,
      @RequestParam(value = "race", required = false)
          String race,
      @RequestParam(value = "birthDateThisMonth", required = false)
          String birthDateThisMonth, Model model)
  {

    AuthToken token = webServiceHelper.login("pravin.gordhan", "pravin.gordhan");
    model.addAttribute(ALL_EMPLOYEES_KEY, webServiceHelper.getAllEmployees(token.getToken()));
    return DASHBOARD;
  }

}