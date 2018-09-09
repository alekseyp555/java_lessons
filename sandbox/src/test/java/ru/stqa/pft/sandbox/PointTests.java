package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testArea1() {
    Point first = new Point(3,2);
    Point second = new Point (2,3);
    Assert.assertEquals(first.distance(second), 1.4142135623730951);

  }
  @Test
  public void TestArea2 () {
    Point first = new Point(1,2);
    Point second = new Point (2,1);
    Assert.assertEquals(first.distance(second), 1.3 );
  }
        }
