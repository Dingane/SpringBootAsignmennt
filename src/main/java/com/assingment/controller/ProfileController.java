package com.assingment.controller;

import static com.assingment.controller.helper.Constants.PROFILE_KEY;

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

  @RequestMapping("/profile")
  public String process(Map<String, Object> model)
  {
    model.put(PROFILE_KEY, webServiceHelper.getProfile(authToken.getToken()));
    return PROFILE_KEY;
  }

}