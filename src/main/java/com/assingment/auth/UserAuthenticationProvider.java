package com.assingment.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import com.assingment.auth.service.LoginService;
import com.assingment.view.User;

public class UserAuthenticationProvider implements AuthenticationProvider
{

  private LoginService loginService;

  public UserAuthenticationProvider(LoginService loginService)
  {
    this.loginService = loginService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException
  {
    String name = authentication.getName();
    Object credentials = authentication.getCredentials();
    Authentication auth = null;
    if (!(credentials instanceof String))
    {
      auth = null;
    }
    else
    {
      String password = credentials.toString();
      User login = loginService.login(name, credentials.toString());

      if (login != null)
      {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        auth = new UsernamePasswordAuthenticationToken(login.getFirst_name() + " " + login.getLast_name(), password, grantedAuthorities);

      }
    }

    return auth;
  }

  @Override
  public boolean supports(Class<?> authentication)
  {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

}