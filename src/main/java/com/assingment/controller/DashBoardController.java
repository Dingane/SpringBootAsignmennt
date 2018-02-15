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

  private static final String DASHBOARD = "dashboard";
  private static final String DASHBOARD1_KEY = "dashboard";

  @RequestMapping("/dashboard")
  public String process(Map<String, Object> model)
  {
    AuthToken token = webServiceHelper.login("pravin.gordhan", "pravin.gordhan");
    model.put(DASHBOARD1_KEY, webServiceHelper.invokeService(WebServiceHelper.GEL_ALL_EMPLOYEES, token.getToken()));
    return DASHBOARD;
  }

}