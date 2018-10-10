package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition () {
    if (app.contact().list().size() == 0) {
    app.goTo().ContactPage();
    app.contact().create(new ContactData().withFirstname("name").withLastname("lastname").withAddress("address").withHomephone("+7495123456789"));
    }
  }

  @Test (enabled = false)
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstname("name").withMiddlename("middle").withLastname("lastname")
            .withNickname("newnick").withTitle("QA").withAddress("new address").withHomephone( "+7495123456789").withGroup(null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
