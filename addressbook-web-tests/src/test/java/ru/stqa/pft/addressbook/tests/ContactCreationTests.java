package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    gotoAddContactPage();
    fillContactForm(new ContactData("name", "middle", "lastname", "newnick", "QA", "mycompany", "new address", "+7495123456789", "+7123456789", "email@my.info", "20", "January", "1900"));
    submitContactForm();
    returnToContactPage();
  }
}
