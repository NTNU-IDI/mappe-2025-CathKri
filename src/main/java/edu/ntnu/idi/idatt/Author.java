package edu.ntnu.idi.idatt;

/**
 *
 */
public class Author {
  public String firstName;
  public String lastName;
  public String email;

  /**
   *
   * @param firstName
   * @param lastName
   * @param email
   */
  public Author(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   *
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @param firstName
   */
  public void setFirstName(String firstName) {
    if (firstName == "" || firstName.isBlank()) {
      throw new IllegalArgumentException("Firstname can not be blank");
    }
    this.firstName = firstName;
  }

  /**
   *
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   *
   * @param lastName
   */
  public void setLastName(String lastName) {
    if (lastName == "" || lastName.isBlank()) {
      throw new IllegalArgumentException("Last name can not be blank");
    }
    this.lastName = lastName;
  }

  /**
   *
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   *
   * @param email
   */
  public void setEmail(String email) {
    if (email == ""  || email.isBlank()) {
      throw new IllegalArgumentException("Email can not be blank");
    }
    this.email = email;
  }
}
