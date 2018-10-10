package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
  public void testContactCreation()  {
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("name").withLastname("lastname").withAddress("address").withHomephone("+7495123456789");
    app.goTo().ContactPage();
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
