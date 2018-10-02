package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion()  {
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddContactPage();
      app.getContactHelper().createContact(new ContactData("name", "middle", "lastname", "newnick", "QA","new address", "+7495123456789",  "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptDeleteContact();
    //gotoHomePage();
  }

}
