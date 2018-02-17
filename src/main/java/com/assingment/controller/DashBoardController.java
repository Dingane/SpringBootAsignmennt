package com.assingment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;

@Controller
public class DashBoardController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  @Autowired
  private AuthToken authToken;

  private static final String DASHBOARD = "dashboard";
  private static final String ALL_EMPLOYEES_KEY = "allEmployees";

  @RequestMapping("/dashboard")
  public String process(Map<String, Object> model)
  {
    model.put(ALL_EMPLOYEES_KEY, webServiceHelper.getAllEmployees(authToken.getToken()));
    return DASHBOARD;
  }

}