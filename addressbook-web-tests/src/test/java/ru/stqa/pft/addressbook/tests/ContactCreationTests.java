package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("firstname1").withLastname("lastname 1").withAddress("address 1")});
    list.add(new Object[] {new ContactData().withFirstname("firstname2").withLastname("lastname 2").withAddress("address 2")});
    list.add(new Object[] {new ContactData().withFirstname("firstname3").withLastname("lastname 3").withAddress("address 3")});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact)  {
    //Contacts before = (Contacts) app.contact().all();
    app.goTo().ContactPage();
    app.contact().initContactCreation();
    //File photo = new File("src/test/resources/test.png");
    //ContactData contact = new ContactData().withFirstname("Vasya").withLastname("Pechkin")
     //       .withPhoto(photo);
    app.contact().create(contact);
    //app.contact().fillContactForm(
    //        new ContactData().withFirstname("Vasya").withLastname("Pechkin").withPhoto(photo));
    //app.contact().submitContactForm();
    //app.contact().gotoHomePage();
    //app.contact().create(contact);
    //assertThat(app.contact().count(), equalTo(before.size() + 1));
    //Contacts after = (Contacts) app.contact().all();
    //assertThat(after, equalTo(
   //        before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
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