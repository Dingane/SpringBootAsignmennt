package com.assingment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;

@Controller
public class HomeController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  private static final String INDEX = "index";
  private static final String MYDETAILS_KEY = "mydetails";
  private static final String ALL_EMPLOYEES_KEY = "allEmployees";

  @RequestMapping("/")
  public String process(Map<String, Object> model)
  {
    AuthToken token = webServiceHelper.login("pravin.gordhan", "pravin.gordhan");
    model.put(MYDETAILS_KEY, webServiceHelper.getLoggedInUserDetails(token.getToken()));
    model.put(ALL_EMPLOYEES_KEY, webServiceHelper.getAllEmployees(token.getToken()));
    return INDEX;
  }

}