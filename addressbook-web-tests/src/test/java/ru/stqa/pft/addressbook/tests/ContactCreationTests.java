package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test ()
  public void testContactCreation()  {
    Contacts before = (Contacts) app.contact().all();
    app.goTo().ContactPage();
    ContactData contact = new ContactData().withFirstname("Vasya").withLastname("Pechkin")
            .withAddress("MyAddress").withHomephone("+7495123456789").withEmail("test@test.com");
    app.contact().create(contact);

    Contacts after = (Contacts) app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
           before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}