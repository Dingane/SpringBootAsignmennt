package com.assingment.view;

public class User
{
  private Integer id;
  private String username;
  private String email;
  private String first_name;
  private String last_name;
  private boolean is_active;
  private boolean is_staff;

  private String is_activeDescription;
  private String is_staffDesc;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getFirst_name()
  {
    return first_name;
  }

  public void setFirst_name(String first_name)
  {
    this.first_name = first_name;
  }

  public String getLast_name()
  {
    return last_name;
  }

  public void setLast_name(String last_name)
  {
    this.last_name = last_name;
  }

  public boolean isIs_active()
  {
    return is_active;
  }

  public void setIs_active(boolean is_active)
  {
    this.is_active = is_active;
  }

  public boolean isIs_staff()
  {
    return is_staff;
  }

  public void setIs_staff(boolean is_staff)
  {
    this.is_staff = is_staff;
  }

  public String getIs_activeDescription()
  {
    return is_activeDescription = is_active ? "Yes" : "No";
  }

  public String getIs_staffDesc()
  {
    return is_staffDesc = is_staff ? "Yes" : "No";
  }

}
