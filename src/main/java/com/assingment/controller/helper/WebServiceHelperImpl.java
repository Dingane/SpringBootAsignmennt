package com.assingment.controller.helper;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.assingment.view.Employee;
import com.assingment.view.User;
import com.assingment.view.AuthToken;

@Component
public class WebServiceHelperImpl implements WebServiceHelper
{
  // TODO inject template
  private final RestTemplate restTemplate = new RestTemplate();

  public String invokeService(String url, String token)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Token " + token);
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
    return response.getBody();
  }

  public Employee getProfile(String token)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Token " + token);
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<Employee> response = restTemplate.exchange(GEL_MY_PROFILE, HttpMethod.GET, request, Employee.class);
    return response.getBody();
  }

  @Override
  public User getLoggedInUserDetails(String token)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Token " + token);
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<User> response = restTemplate.exchange(LOGGED_IN_USER_DETAILS_URL, HttpMethod.GET, request, User.class);
    return response.getBody();
  }

  @Override
  public List<Employee> getAllEmployees(String token)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Token " + token);
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<Employee[]> response = restTemplate.exchange(GEL_ALL_EMPLOYEES, HttpMethod.GET, request, Employee[].class);

    return Arrays.asList(response.getBody());
  }

  @Override
  public List<Employee> getAllEmployeesBy(String race, String gender, String token)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Token " + token);
    HttpEntity<String> request = new HttpEntity<>(headers);
    ResponseEntity<Employee[]> response = restTemplate.exchange(GEL_ALL_EMPLOYEES + "?race={race}&gender={gender}", HttpMethod.GET, request, Employee[].class, race, gender);

    return Arrays.asList(response.getBody());
  }

  public AuthToken login(String username, String password)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}", headers);
    return restTemplate.postForObject(AUTH_URL, entity, AuthToken.class);

  }
}
