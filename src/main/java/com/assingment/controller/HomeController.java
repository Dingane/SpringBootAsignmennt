package com.assingment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;

@Controller
public class HomeController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  @Autowired
  private AuthToken authToken;

  private static final String INDEX = "home";
  private static final String MYDETAILS_KEY = "mydetails";
  private static final String ALL_EMPLOYEES_KEY = "allEmployees";

  @RequestMapping("/home")
  public String process(Map<String, Object> model)
  {
    model.put(MYDETAILS_KEY, webServiceHelper.getLoggedInUserDetails(authToken.getToken()));
    model.put(ALL_EMPLOYEES_KEY, webServiceHelper.getAllEmployees(authToken.getToken()));
    return INDEX;
  }

}