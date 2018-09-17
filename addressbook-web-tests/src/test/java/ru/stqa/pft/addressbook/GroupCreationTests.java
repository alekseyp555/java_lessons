package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test 1", "test 2", "test 3"));
    submitGroupCreation();
    returnToGroupPage();
   // wd.findElement(By.linkText("Logout")).click();
   // wd.findElement(By.name("user")).clear();
   // wd.findElement(By.name("user")).sendKeys("admin");
  }

}
