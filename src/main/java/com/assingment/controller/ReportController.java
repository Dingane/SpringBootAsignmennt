package com.assingment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assingment.controller.helper.WebServiceHelper;
import com.assingment.dashboardchart.Chart;
import com.assingment.dashboardchart.Data;
import com.assingment.dashboardchart.DataSource;
import com.assingment.dashboardchart.JSONHelper;
import com.assingment.view.AuthToken;

import static com.assingment.controller.helper.Constants.*;

@RestController
public class ReportController
{
  @Autowired
  private WebServiceHelper webServiceHelper;

  @Autowired
  private AuthToken authToken;

  @RequestMapping(value = "/reportData")
  public String computeReportData(
      @RequestParam(value = "type")
          String type)
  {
    return JSONHelper.toJSON(getDataSource(type));
  }

  private DataSource getDataSource(String type)
  {
    DataSource dataSource = null;
    if (RACE_KEY.equals(type))
    {
      dataSource = getRaceGraph();
    }
    else if (GENDER_KEY.equals(type))
    {
      dataSource = getGenderGraph();
    }
    return dataSource;
  }

  private DataSource getRaceGraph()
  {
    Chart chart = new Chart();

    chart.setCaption(EMPLOYEE_RACE);
    chart.setSubCaption(EMPTY_STRING);
    chart.setxAxisName(EMPTY_STRING);
    chart.setyAxisName(EMPTY_STRING);
    chart.setTheme(CHART_THEME_FINT);

    List<Data> dataList = new ArrayList<>();

    Data data = new Data();

    data.setLabel(BLACK);
    data.setValue(webServiceHelper.getAllEmployeesBy(RACE_BLACK_KEY, EMPTY_STRING, authToken.getToken()).size());
    dataList.add(data);

    data = new Data();
    data.setLabel(WHITE);
    data.setValue(webServiceHelper.getAllEmployeesBy(RACE_WHITE_KEY, EMPTY_STRING, authToken.getToken()).size());
    dataList.add(data);

    data = new Data();
    data.setLabel(COLORED);
    data.setValue(webServiceHelper.getAllEmployeesBy(RACE_COLORED_KEY, EMPTY_STRING, authToken.getToken()).size());
    dataList.add(data);

    data = new Data();
    data.setLabel(IDIAN);
    data.setValue(webServiceHelper.getAllEmployeesBy(RACE_INDIAN_KEY, EMPTY_STRING, authToken.getToken()).size());
    dataList.add(data);

    data = new Data();
    data.setLabel(NONE_DOMINENT);
    data.setValue(webServiceHelper.getAllEmployeesBy(RACE_NON_DOMINANT_KEY, EMPTY_STRING, authToken.getToken()).size());
    dataList.add(data);

    DataSource dataSource = new DataSource();
    dataSource.setChart(chart);
    dataSource.setData(dataList);
    return dataSource;
  }

  private DataSource getGenderGraph()
  {
    Chart chart = new Chart();

    chart.setCaption(EMPLOYEE_GENDER);
    chart.setSubCaption(EMPTY_STRING);
    chart.setxAxisName(EMPTY_STRING);
    chart.setyAxisName(EMPTY_STRING);
    chart.setTheme(CHART_THEME_FINT);

    List<Data> dataList = new ArrayList<>();

    Data data = new Data();
    data.setLabel(FEMALE);
    data.setValue(webServiceHelper.getAllEmployeesBy(EMPTY_STRING, GENDER_FEMALE_KEY, authToken.getToken()).size());
    dataList.add(data);

    data = new Data();
    data.setLabel(MALE);
    data.setValue(webServiceHelper.getAllEmployeesBy(EMPTY_STRING, GENDER_MALE_KEY, authToken.getToken()).size());
    dataList.add(data);

    DataSource dataSource = new DataSource();
    dataSource.setChart(chart);
    dataSource.setData(dataList);
    return dataSource;
  }

}