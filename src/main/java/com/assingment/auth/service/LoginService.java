package com.assingment.auth.service;

import org.springframework.security.core.Authentication;

import com.assingment.view.User;

public interface LoginService
{
  User login(String username, String password);
}

