package com.assingment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;

@Controller
public class ProfileController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  private static final String PROFILE_KEY = "profile";

  @RequestMapping("/profile")
  public String process(Map<String, Object> model)
  {
    AuthToken token = webServiceHelper.login("pravin.gordhan", "pravin.gordhan");
    model.put(PROFILE_KEY, webServiceHelper.invokeService(WebServiceHelper.GEL_MY_PROFILE, token.getToken()));
    return PROFILE_KEY;
  }

}