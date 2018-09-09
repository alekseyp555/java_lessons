package ru.stqa.pft.sandbox;
public class Point {

  public double x;
  public double y;

  //public Point (double x, double y) {
  //m_x = x;
  // m_y = y;
  //}

  public Point (double x, double y) {
    this.m_x = x;
    this.m_y = y;
  }

  public double distance(Point p2)
  {
    return Math.sqrt(Math.pow(p2.GetX() - this.GetX(),2) + Math.pow(p2.GetY() - this.GetY(),2));
  }

  public double GetX()
  {
    return m_x;
  }

  public double GetY()
  {
    return m_y;
  }

  private double m_x;
  private double m_y;

}