package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends  HelperBase{

  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() { click(By.linkText("groups"));

  }

  public void gotoContactPage() { wd.findElement(By.linkText("add new")).click(); }
}