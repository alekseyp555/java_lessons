package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
  @Id
  @Column(name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  //@Transient
  //private String group;



  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Transient
  private String address2;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public Groups getGroups() {
    return new Groups(groups);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    return homephone != null ? homephone.equals(that.homephone) : that.homephone == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
    return result;
  }

  @Column(name = "home")
  @Type(type = "text")
  private String homephone;

  @Transient
  private String email;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile;

  @Column(name = "work")
  @Type(type = "text")
  private String workphone;

  @Transient
  private String email2;

  @Transient
  private String email3;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Transient
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withhAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withWorkPhone (String workPhone) {
    this.workphone = workPhone;
    return this;
  }

  public ContactData withMobile (String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  //public ContactData withGroup(String group) {
   // this.group = group;
   // return this;
  //}

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", homephone='" + homephone + '\'' +
     //       ", group='" + group + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getEmail() {return  email; }

  //public String getGroup() {
  //  return group;
  //}

  public String getMobile() {return mobile;}

  public String getWorkphone() {return workphone;}

  public String getEmail2() {return  email2;}

  public String getEmail3() {return  email3;}

  public String getAllPhones() {return  allPhones;}

  public String getAllEmails() {return  allEmails;}

  public String getAddress2() {
    return address2;
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
