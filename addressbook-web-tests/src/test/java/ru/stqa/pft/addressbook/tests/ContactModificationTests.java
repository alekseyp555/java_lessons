package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().ContactPage();
    if (app.db().contacts().size() == 0) {
    app.contact().create(new ContactData().withFirstname("name").withLastname("lastname"));
    }
  }

  @Test ()
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    //File photo = new File("src/test/resources/test.png");
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Vasya").withLastname("Pupkin")
            .withAddress("new address").withHomephone( "+7495123456789");
    app.goTo().HomePage();
    app.contact().modify(contact);

    //assertThat(app.contact().count(), equalTo(before.size() ));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
  }
}
