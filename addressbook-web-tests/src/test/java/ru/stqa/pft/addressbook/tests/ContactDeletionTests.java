package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition () {
    if (app.contact().list().size() == 0) {
      app.goTo().ContactPage();
      app.contact().create(new ContactData().withFirstname("name").withLastname("lastname").withAddress("address").withHomephone("+7495123456789"));
    }
  }

  @Test (enabled = false)
  public void testContactDeletion()  {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }



}
