package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
  public void testContactCreation()  {
    Contacts before = (Contacts) app.contact().all();
    ContactData contact = new ContactData().withFirstname("name").withLastname("lastname").withAddress("address").withHomephone("+7495123456789");
    app.goTo().ContactPage();
    app.contact().create(contact);
    Contacts after = (Contacts) app.contact().all();
    assertThat((after.size(), equalTo(before.size() + 1));
    assertThat((after, equalTo(
           before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}