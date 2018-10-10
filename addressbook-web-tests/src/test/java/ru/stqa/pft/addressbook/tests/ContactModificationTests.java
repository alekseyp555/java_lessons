package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
    if (app.contact().all().size() == 0) {
    app.goTo().ContactPage();
    app.contact().create(new ContactData().withFirstname("name").withLastname("lastname").withAddress("address").withHomephone("+7495123456789"));
    }
  }

  @Test (enabled = false)
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("name").withMiddlename("middle").withLastname("lastname")
            .withNickname("newnick").withTitle("QA").withAddress("new address").withHomephone( "+7495123456789").withGroup(null);
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
