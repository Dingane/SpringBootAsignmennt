package com.assingment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;
import com.assingment.view.Employee;

@Controller
public class ProfileController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  @Autowired
  private AuthToken authToken;

  private static final String PROFILE_KEY = "profile";

  @RequestMapping("/profile")
  public String process(Map<String, Object> model)
  {
    Employee profile = webServiceHelper.getProfile(authToken.getToken());
    model.put(PROFILE_KEY, profile);
    return PROFILE_KEY;
  }

}