package com.assingment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assingment.view.AuthToken;

@Controller
public class DefaultController
{

  @Autowired
  private AuthToken authToken;

  @GetMapping("/")
  public String root()
  {
    return "/index";
  }

  @GetMapping("/403")
  public String error403()
  {
    return "/error/403";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login(
      @RequestParam(value = "error", required = false)
          String error,
      @RequestParam(value = "logout", required = false)
          String logout)
  {

    ModelAndView model = new ModelAndView();
    if (error != null)
    {
      model.addObject("error", "Invalid username and password!");
    }

    if (logout != null)
    {
      model.addObject("msg", "You've been logged out successfully.");
      authToken.setToken(null);
    }
    model.setViewName("login");

    return model;

  }

}
