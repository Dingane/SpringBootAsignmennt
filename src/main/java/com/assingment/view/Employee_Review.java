package com.assingment.view;

public class Employee_Review
{
  private String id;
  private String date;
  private String salary;
  private String type;
  private String description;

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getSalary()
  {
    return salary;
  }

  public void setSalary(String salary)
  {
    this.salary = salary;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getDescription()
  {
    if (type.equals("P"))
    {
      description = "Performance Increase";
    }
    else if (type.equals("S"))
    {
      description = "Starting Salary";
    }
    else if (type.equals("A"))
    {
      description = "Annual Increase";
    }
    else if (type == "E")
    {
      description = "Expectation Review";
    }
    return description;
  }
}
