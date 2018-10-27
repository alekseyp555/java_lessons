package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().ContactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Delete").withLastname("Deletion"));
    }
  }
  @Test
  public void testContactDeletion()  {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }



}
