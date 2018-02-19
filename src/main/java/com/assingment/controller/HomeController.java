package com.assingment.controller;

import static com.assingment.controller.helper.Constants.ALL_EMPLOYEES_KEY;
import static com.assingment.controller.helper.Constants.HOME;
import static com.assingment.controller.helper.Constants.MYDETAILS_KEY;

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

  @Autowired
  private AuthToken authToken;

  @RequestMapping("/home")
  public String process(Map<String, Object> model)
  {
    model.put(MYDETAILS_KEY, webServiceHelper.getLoggedInUserDetails(authToken.getToken()));
    model.put(ALL_EMPLOYEES_KEY, webServiceHelper.getAllEmployees(authToken.getToken()));
    return HOME;
  }

}