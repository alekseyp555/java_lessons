package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) { super(wd);  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomephone());

    if (creation) {
      new Select(wd.findElement(By.name("new group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new group")));
    }
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void acceptDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void submitContactForm() { click(By.name("submit")); }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void create(ContactData contact) {
    fillContactForm(new ContactData().withFirstname("name").withMiddlename("middle").withLastname("lastname")
            .withNickname("newnick").withTitle("QA").withAddress("new address").withHomephone("+7495123456789").withGroup("test1"),true);
    submitContactForm();
    gotoHomePage();
  }

  public void modify(int index, ContactData contact) {
    selectContact(index);
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    gotoHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
    acceptDeleteContact();
    gotoHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contactslist = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("td center"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
       contactslist.add(new ContactData().withId(id).withFirstname("name").withMiddlename(null).withLastname("lastname"));
    }
    return contactslist;
  }
}
