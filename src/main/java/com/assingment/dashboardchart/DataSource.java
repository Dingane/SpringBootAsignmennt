package com.assingment.dashboardchart;

import java.util.List;

public class DataSource
{
  private Chart chart;
  private List<Data> data;

  public Chart getChart()
  {
    return chart;
  }

  public void setChart(Chart chart)
  {
    this.chart = chart;
  }

  public List<Data> getData()
  {
    return data;
  }

  public void setData(List<Data> data)
  {
    this.data = data;
  }
}
