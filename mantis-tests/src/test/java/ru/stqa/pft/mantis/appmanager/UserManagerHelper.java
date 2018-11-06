package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserManagerHelper extends HelperBase {
  public UserManagerHelper(ApplicationManager app) {
    super(app);
  }

  public void reset(String username) {
    click(By.linkText(username));
    click(By.xpath("//input[3]"));
  }

  public void confirmade(String conformationLink, String password) {
    wd.get(conformationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
}