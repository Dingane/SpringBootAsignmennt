package com.assingment.controller.helper;

import com.assingment.view.AuthToken;
import com.assingment.view.Employee;

public interface WebServiceHelper
{
  String LOGGED_IN_USER_DETAILS_URL = "http://staging.tangent.tngnt.co/api/user/me/";
  String GEL_ALL_EMPLOYEES = "http://staging.tangent.tngnt.co/api/employee/";
  String GEL_MY_PROFILE = "http://staging.tangent.tngnt.co/api/employee/me/";
  String AUTH_URL = "http://staging.tangent.tngnt.co/api-token-auth/";

  String invokeService(String url, String token);

  AuthToken login(String username, String password);

  Employee getProfile(String token);

}
