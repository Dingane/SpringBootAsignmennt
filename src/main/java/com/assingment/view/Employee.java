package com.assingment.view;

import java.util.List;

public class Employee
{
  private String id_number;
  private String phone_number;
  private String physical_address;
  private String tax_number;
  private String email;
  private String personal_email;
  private String github_user;
  private String birth_date;
  private String start_date;
  private String end_date;
  private String id_document;
  private String visa_document;
  private boolean is_employed;
  private boolean is_foreigner;
  private String is_employedDescription;
  private String is_foreignerDescription;
  private String gender;
  private String race;
  private String genderDescription;
  private String raceDescription;
  private int years_worked;
  private int age;
  private String next_review;
  private String days_to_birthday;
  private String leave_remaining;
  private List<Employee_Review> employee_review;
  private User user;
  private Position position;
  //  private Employee_Next_Of_Kin employee_next_of_kin;

  public String getId_number()
  {
    return id_number;
  }

  public void setId_number(String id_number)
  {
    this.id_number = id_number;
  }

  public String getPhone_number()
  {
    return phone_number;
  }

  public void setPhone_number(String phone_number)
  {
    this.phone_number = phone_number;
  }

  public String getPhysical_address()
  {
    return physical_address;
  }

  public void setPhysical_address(String physical_address)
  {
    this.physical_address = physical_address;
  }

  public String getTax_number()
  {
    return tax_number;
  }

  public void setTax_number(String tax_number)
  {
    this.tax_number = tax_number;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPersonal_email()
  {
    return personal_email;
  }

  public void setPersonal_email(String personal_email)
  {
    this.personal_email = personal_email;
  }

  public String getGithub_user()
  {
    return github_user;
  }

  public void setGithub_user(String github_user)
  {
    this.github_user = github_user;
  }

  public String getBirth_date()
  {
    return birth_date;
  }

  public void setBirth_date(String birth_date)
  {
    this.birth_date = birth_date;
  }

  public String getStart_date()
  {
    return start_date;
  }

  public void setStart_date(String start_date)
  {
    this.start_date = start_date;
  }

  public String getEnd_date()
  {
    return end_date;
  }

  public void setEnd_date(String end_date)
  {
    this.end_date = end_date;
  }

  public String getId_document()
  {
    return id_document;
  }

  public void setId_document(String id_document)
  {
    this.id_document = id_document;
  }

  public String getVisa_document()
  {
    return visa_document;
  }

  public void setVisa_document(String visa_document)
  {
    this.visa_document = visa_document;
  }

  public boolean isIs_employed()
  {
    return is_employed;
  }

  public void setIs_employed(boolean is_employed)
  {
    this.is_employed = is_employed;
  }

  public boolean isIs_foreigner()
  {
    return is_foreigner;
  }

  public void setIs_foreigner(boolean is_foreigner)
  {
    this.is_foreigner = is_foreigner;
  }

  public String getGender()
  {
    return gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  public String getRace()
  {
    return race;
  }

  public void setRace(String race)
  {
    this.race = race;
  }

  public int getYears_worked()
  {
    return years_worked;
  }

  public void setYears_worked(int years_worked)
  {
    this.years_worked = years_worked;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public String getNext_review()
  {
    return next_review;
  }

  public void setNext_review(String next_review)
  {
    this.next_review = next_review;
  }

  public String getDays_to_birthday()
  {
    return days_to_birthday;
  }

  public void setDays_to_birthday(String days_to_birthday)
  {
    this.days_to_birthday = days_to_birthday;
  }

  public String getLeave_remaining()
  {
    return leave_remaining;
  }

  public void setLeave_remaining(String leave_remaining)
  {
    this.leave_remaining = leave_remaining;
  }

  public List<Employee_Review> getEmployee_review()
  {
    return employee_review;
  }

  public void setEmployee_review(List<Employee_Review> employee_review)
  {
    this.employee_review = employee_review;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public Position getPosition()
  {
    return position;
  }

  public void setPosition(Position position)
  {
    this.position = position;
  }

  //  public Employee_Next_Of_Kin getEmployee_next_of_kin()
  //  {
  //    return employee_next_of_kin;
  //  }
  //
  //  public void setEmployee_next_of_kin(Employee_Next_Of_Kin employee_next_of_kin)
  //  {
  //    this.employee_next_of_kin = employee_next_of_kin;
  //  }

  public String getGenderDescription()
  {

    return genderDescription = gender.equals("M") ? "Male" : "Female";
  }

  public String getRaceDescription()
  {
    if (race.equals("B"))
    {
      raceDescription = "Black";
    }
    else if (race.equals("W"))
    {
      raceDescription = "White";
    }
    else if (race.equals("I"))
    {
      raceDescription = "Indian or Asian";
    }
    else if (race.equals("C"))
    {
      raceDescription = "Colored";
    }
    else
    {
      raceDescription = "None Dominant";
    }
    return raceDescription;
  }

  public String getIs_employedDescription()
  {
    return is_employedDescription = is_employed ? "Yes" : "No";
  }

  public String getIs_foreignerDescription()
  {
    return is_foreignerDescription = is_foreigner ? "Yes" : "No";
  }
}
