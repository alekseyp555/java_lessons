package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddContactPage();
    app.getContactHelper().createContact(new ContactData("name", "middle", "lastname", "newnick", "QA","new address", null,  null));
    int after = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoHomePage();
    Assert.assertEquals(after, before + 1);
  }
}
