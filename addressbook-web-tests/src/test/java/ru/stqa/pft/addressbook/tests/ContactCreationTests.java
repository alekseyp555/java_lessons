package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test ()
  public void testContactCreation()  {
    Contacts before = (Contacts) app.contact().all();
    app.goTo().ContactPage();
    //лекция 6.1
    //app.contact().initContactCreation();
    //File photo = new File("src/test/resources/test.png");
    ContactData contact = new ContactData().withFirstname("Vasya").withLastname("Pechkin").withAddress("new address");
    //        .withPhoto(photo);
    //лекция 6.1
    //app.contact().fillContactForm(
    //        new ContactData().withFirstname("Vasya").withLastname("Pechkin").withPhoto(photo)
    //);
    //лекция 6.1
    //app.contact().submitContactForm();
    //app.contact().gotoHomePage();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = (Contacts) app.contact().all();
    assertThat(after, equalTo(
           before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
  public void testBadContactCreation()  {
    Contacts before = (Contacts) app.contact().all();
    app.goTo().ContactPage();
    ContactData contact = new ContactData().withFirstname("Vasya'");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = (Contacts) app.contact().all();
    assertThat(after, equalTo(before));
  }
}