package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {

 private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    //type(By.name("company"), contactData.getCompanyname());
    click(By.name("address"));
    type(By.name("address"), contactData.getAddress());
    //click(By.name("theform"));
    type(By.name("home"), contactData.getHomephone());
    type(By.name("work"), contactData.getWorkphone());
    //type(By.name("email"), contactData.getEmail());
    //click(By.name("bday"));
    //new Select(wd.findElement(By.name("bday"))).selectByVisibleText("20");
    //click(By.xpath("//option[@value='20']"));
    //click(By.name("bmonth"));
   // click(By.name("bmonth"));
    //new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("January");
    //click(By.xpath("//option[@value='January']"));
    //type(By.name("byear"), contactData.getByear());
  }

  private void type(By locator, String text) {
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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void submitContactForm() {
    wd.get("http://localhost/addressbook/edit.php");
    click(By.name("submit"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  private void click(By locator) {
    wd.findElement(locator).click();
  }
}


