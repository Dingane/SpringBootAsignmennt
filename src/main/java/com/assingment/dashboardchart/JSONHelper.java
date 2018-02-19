package com.assingment.dashboardchart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHelper
{

  private static Logger logger = LoggerFactory.getLogger(JSONHelper.class);
  private static final ObjectMapper mapper = new ObjectMapper();

  public static String toJSON(Object object)
  {
    String json = null;
    try
    {
      json = mapper.writeValueAsString(object);
    }
    catch (JsonProcessingException e)
    {
      logger.error(JSONHelper.class.getName(), e.getLocation());
    }
    return json;
  }

}
