package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  //private final String companyname;
  private final String address;
  private final String homephone;
  private final String workphone;
  //private final String email;
 // private final String bday;
 // private final String bmonth;
  // private final String byear;
   public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String address, String homephone, String workphone) {
   //public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String companyname, String address, String homephone, String workphone, String email, String bday, String bmonth, String byear) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    //this.companyname = companyname;
    this.address = address;
    this.homephone = homephone;
    this.workphone = workphone;
    //this.email = email;
    //this.bday = bday;
    //this.bmonth = bmonth;
    //this.byear = byear;
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

  public String getTitle() {
    return title;
  }

 // public String getCompanyname() {
  //  return companyname;
  //}

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getWorkphone() {
    return workphone;
  }

  //public String getEmail() {
   // return email;
  //}

  //public String getBday() {
    //return bday;
  //}

  //public String getBmonth() {
    //return bmonth;
  //}

  //public String getByear() {
    //return byear;
  //}
}
