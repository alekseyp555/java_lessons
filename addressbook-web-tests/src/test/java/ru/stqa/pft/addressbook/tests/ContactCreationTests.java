package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts () throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2])});
      line = reader.readLine();
    }
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