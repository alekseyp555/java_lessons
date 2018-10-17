package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) { super(wd);  }

  public void gotoHomePage() {
    click(By.linkText("home"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    //attach(By.name("photo"), contactData.getPhoto());
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void acceptDeleteContact() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.xpath("//input[@value='" + id + "']/../../td/a/img[@title='Edit']")).click();
  }

  public void submitContactForm() { click(By.name("submit")); }

  public void initContactModificationById(int id) {

    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    //wd.findElement(By.xpath(String.format("//input[value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactForm();
    contactCache = null;
    gotoHomePage();
  }

  public void initContactCreation() {
    click(By.name("firstname"));
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    contactCache = null;
    gotoHomePage();
  }

  public void delete(ContactData Contact) {
    selectContactById(Contact.getId());
    deleteSelectedContact();
    acceptDeleteContact();
    contactCache = null;
    gotoHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if(contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));

      String lastname = tr.get(1).getText();
      String name = tr.get(2).getText();
      String allEmails = tr.get(4).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id).withFirstname(name).withLastname(lastname)
              .withhAllEmails(allEmails));

 }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }
}
