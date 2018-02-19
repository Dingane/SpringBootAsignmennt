package com.assingment.dashboardchart;

public class Chart
{
  private String caption;
  private String subCaption;
  private String xAxisName;
  private String yAxisName;
  private String theme;

  public String getCaption()
  {
    return caption;
  }

  public void setCaption(String caption)
  {
    this.caption = caption;
  }

  public String getSubCaption()
  {
    return subCaption;
  }

  public void setSubCaption(String subCaption)
  {
    this.subCaption = subCaption;
  }

  public String getxAxisName()
  {
    return xAxisName;
  }

  public void setxAxisName(String xAxisName)
  {
    this.xAxisName = xAxisName;
  }

  public String getyAxisName()
  {
    return yAxisName;
  }

  public void setyAxisName(String yAxisName)
  {
    this.yAxisName = yAxisName;
  }

  public String getTheme()
  {
    return theme;
  }

  public void setTheme(String theme)
  {
    this.theme = theme;
  }
}
