package com.assingment.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;
import com.assingment.view.User;

@Service
public class LoginServiceImpl implements LoginService
{

  private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
  @Autowired
  private WebServiceHelper webServiceHelper;

  @Autowired
  private AuthToken authToken;

  @Override
  public User login(String username, String password)
  {

    User loggedInUserDetails = null;

    try
    {
      AuthToken login = webServiceHelper.login(username, password);
      if (login != null)
      {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authToken.setToken(login.getToken());
        loggedInUserDetails = webServiceHelper.getLoggedInUserDetails(authToken.getToken());
      }
    }
    catch (Exception e)
    {
      //TODO handle errors better
      logger.error("ERROR Invoking service : " + e.getMessage());
    }

    return loggedInUserDetails;

  }
}
