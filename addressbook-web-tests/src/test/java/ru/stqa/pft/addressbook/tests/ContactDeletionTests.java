package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion()   {

    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContacts();
    app.getGroupHelper().acceptDeleteSelectedContacts();
    app.getGroupHelper().returnToContactPage();

  }

}