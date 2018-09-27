package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String homephone;
  private final String workphone;
  private final String email;
<<<<<<< HEAD
=======
  private final String bday;
  private final String bmonth;
  private final String byear;
>>>>>>> parent of 4dade17... Половина работы по выделению помощников для создания нового контакта

  public ContactData(String firstname, String middlename, String lastname, String nickname, String address, String homephone, String workphone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.homephone = homephone;
    this.workphone = workphone;
    this.email = email;
<<<<<<< HEAD
=======
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
>>>>>>> parent of 4dade17... Половина работы по выделению помощников для создания нового контакта
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getWorkphone() {
    return workphone;
  }

  public String getEmail() {
    return email;
  }

<<<<<<< HEAD
=======
  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }
>>>>>>> parent of 4dade17... Половина работы по выделению помощников для создания нового контакта
}
