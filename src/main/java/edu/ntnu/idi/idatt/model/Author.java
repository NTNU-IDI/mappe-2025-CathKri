package edu.ntnu.idi.idatt.model;

import java.util.Objects;

/**
 * Represents an author of a diary entry. An author has a first name,
 * last name and an email address. The class provides validation to ensure that
 * these fields are not blank.
 */
public class Author {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Creates a new Author with the given information.
   *
   * @param firstName the author's first name (can not be blank)
   * @param lastName  the author's last name (can not be blank)
   * @param email     the author's email address (can not be blank)
   * @throws IllegalArgumentException if any parameter is blank
   */
  public Author(String firstName, String lastName, String email) {
    if (firstName == null || firstName.isBlank()
        || lastName == null || lastName.isBlank()
        || email == null || email.isBlank()) {
      throw new IllegalArgumentException("Author can not be blank");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Gets the author's first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the author's first name.
   *
   * @param firstName the new first name (can not be blank)
   * @throws IllegalArgumentException if the value is blank
   */
  public void setFirstName(String firstName) {
    if (Objects.equals(firstName, "") || firstName.isBlank()) {
      throw new IllegalArgumentException("Firstname can not be blank");
    }
    this.firstName = firstName;
  }

  /**
   * Gets the author's last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the author's last name.
   *
   * @param lastName the new last name (can not be blank)
   * @throws IllegalArgumentException if the value is blank
   */
  public void setLastName(String lastName) {
    if (Objects.equals(lastName, "") || lastName.isBlank()) {
      throw new IllegalArgumentException("Last name can not be blank");
    }
    this.lastName = lastName;
  }

  /**
   * Gets the author's email address.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the author's email.
   *
   * @param email the new email address (can not be blank)
   * @throws IllegalArgumentException if the value is blank
   */
  public void setEmail(String email) {
    if (Objects.equals(email, "") || email.isBlank()) {
      throw new IllegalArgumentException("Email can not be blank");
    }
    this.email = email;
  }
}
