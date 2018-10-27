package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroup  extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().ContactPage();
      app.contact().initContactCreation();
      app.contact().create(new ContactData()
              .withFirstname("Vasya").withLastname("Pupkin").withAddress("new address ").withHomephone("+7495123456789"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void testContactAddToGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    Groups allGroups = app.db().groups();
    GroupData addedGroup = allGroups.iterator().next();
    if (allGroups.equals(contact.getGroups())) {
      app.goTo().HomePage();
      app.contact().removeFromGroup(contact, addedGroup);
    }
    allGroups.removeAll(contact.getGroups());
    app.goTo().HomePage();
    app.contact().addToGroup(contact, addedGroup);
    app.db().refresh(contact);
    assertThat(contact.getGroups(), hasItem(addedGroup));
  }
}
