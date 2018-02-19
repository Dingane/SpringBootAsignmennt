package com.assingment.controller;

import static com.assingment.controller.helper.Constants.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.view.AuthToken;
import com.assingment.view.Employee;

@Controller
public class DashBoardController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  @Autowired
  private AuthToken authToken;

  @RequestMapping("/dashboard")
  public String process(Map<String, Object> model)
  {
    List<Employee> employees = webServiceHelper.getAllEmployees(authToken.getToken());
    model.put(ALL_EMPLOYEES_KEY, employees);
    generalEmployeesData(model, employees);
    return DASHBOARD;
  }

  @RequestMapping(value = "/search")
  public String search(
      @RequestParam(value = "search_name", required = false)
          String search_name, Map<String, Object> model)
  {
    List<Employee> allEmployees = webServiceHelper.getAllEmployees(authToken.getToken());
    List<Employee> employees = getEmployeesHaving(search_name, allEmployees);
    generalEmployeesData(model, employees);
    model.put(ALL_EMPLOYEES_KEY, employees);
    return DASHBOARD;
  }

  private List<Employee> getEmployeesHaving(String searchTerm, List<Employee> allEmployees)
  {
    List<Employee> employees = new ArrayList<>();
    for (Employee employee : allEmployees)
    {
      if (employee.getUser().getLast_name().contains(searchTerm) || employee.getUser().getFirst_name().contains(searchTerm) || employee.getUser().getEmail().contains(searchTerm)
          || employee.getUser().getUsername().contains(searchTerm) || employee.getPosition().getName().contains(searchTerm) || employee.getPosition().getLevel()
          .contains(searchTerm))
      {
        employees.add(employee);
      }
    }
    return employees;
  }

  private void generalEmployeesData(Map<String, Object> model, List<Employee> employees)
  {
    model.put(NUMBER_OF_COLORED_EMPLOYEES, webServiceHelper.getAllEmployeesBy(RACE_COLORED_KEY, EMPTY_STRING, authToken.getToken()).size());
    model.put(NUMBER_OF_BLACK_EMPLOYEES, webServiceHelper.getAllEmployeesBy(RACE_BLACK_KEY, EMPTY_STRING, authToken.getToken()).size());
    model.put(NUMBER_OF_INDIAN_EMPLOYEES, webServiceHelper.getAllEmployeesBy(RACE_INDIAN_KEY, EMPTY_STRING, authToken.getToken()).size());
    model.put(NUMBER_OF_WHITE_EMPLOYEES, webServiceHelper.getAllEmployeesBy(RACE_WHITE_KEY, EMPTY_STRING, authToken.getToken()).size());
    model.put(NUMBER_OF_NON_DOMINANT_EMPLOYEES, webServiceHelper.getAllEmployeesBy(RACE_NON_DOMINANT_KEY, EMPTY_STRING, authToken.getToken()).size());
    model.put(NUMBER_OF_EMPLOYEES, employees.size());
    model.put(NUMBER_OF_FEMALE_EMPLOYEES, webServiceHelper.getAllEmployeesBy(EMPTY_STRING, GENDER_FEMALE_KEY, authToken.getToken()).size());
    model.put(NUMBER_OF_MALE_EMPLOYEES, webServiceHelper.getAllEmployeesBy(EMPTY_STRING, GENDER_MALE_KEY, authToken.getToken()).size());
    model.put(EMPLOYEES_HAVING_BIRTH_DATE_THIS_MONTH, employeesHavingBirthDayThisMonth(employees));
  }

  private List<Employee> employeesHavingBirthDayThisMonth(List<Employee> employees)
  {
    List<Employee> employeesHavingBirthDateThisMonth = new ArrayList<>();
    Date today = new Date();
    for (Employee employee : employees)
    {
      if (today.getMonth() == employee.getBirth_date().getMonth())
      {
        employeesHavingBirthDateThisMonth.add(employee);
      }
    }
    return employeesHavingBirthDateThisMonth;
  }

}