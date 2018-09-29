package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  private ContactHelper contactHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHlelper;
  private NavigationHelper navigationHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHlelper = new SessionHelper(wd);
    sessionHlelper.login("admin", "secret");
    contactHelper = new ContactHelper(wd);
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() { return contactHelper; }

}
