package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.appmanager.HelperBase;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
    super (app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baserUrl") + "/signup_page.php");
    type(By.name("username"), (username));
    type(By.name("email"), (email));
    click(By.cssSelector("input[value='Signup']"));
  }
}