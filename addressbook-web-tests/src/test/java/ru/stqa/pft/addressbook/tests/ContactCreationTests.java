package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    app.getNavigationHelper().gotoAddContactPage();
    app.getContactHelper().fillContactForm(new ContactData("name", "middle", "lastname", "newnick", "QA", "mycompany", "new address", "+7495123456789", "+7123456789", "email@my.info", "20", "January", "1900"));
    app.getContactHelper().submitContactForm();
    app.getContactHelper().returnToContactPage();
  }
}
