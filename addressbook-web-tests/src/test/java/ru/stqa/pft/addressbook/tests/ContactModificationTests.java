package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("name", "middle", "lastname", "newnick", "QA","new address", "+7495123456789", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();
  }
}
