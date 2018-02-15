package com.assingment.controller.helper;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

  public AuthToken login(String username, String password)
  {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<>("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}", headers);
    return restTemplate.postForObject(AUTH_URL, entity, AuthToken.class);

  }
}
