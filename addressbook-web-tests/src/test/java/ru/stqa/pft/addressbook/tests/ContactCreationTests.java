package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation()   {

    app.getNavigationHelper().gotoContactPage();
    app.getGroupHelper().fillContactForm(new ContactData("name", "middle", "lastname", "newnick", "QA", "mycompany", "new address", "+7495123456789"));
    app.getGroupHelper().returnToContactPage();

  }

}
