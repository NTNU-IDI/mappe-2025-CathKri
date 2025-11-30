package edu.ntnu.idi.idatt;

public class Author {
  public String firstName;
  public String lastName;
  public String email;


  public Author(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    if (firstName == "" || firstName.isBlank()) {
      throw new IllegalArgumentException("Firstname can not be blank");
    }
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    if (lastName == "" || lastName.isBlank()) {
      throw new IllegalArgumentException("Last name can not be blank");
    }
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    if (email == ""  || email.isBlank()) {
      throw new IllegalArgumentException("Email can not be blank");
    }
    this.email = email;
  }
}
