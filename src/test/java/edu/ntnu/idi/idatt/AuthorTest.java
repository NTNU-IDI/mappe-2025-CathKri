package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for verifying the functionality of the {@link Author} class.
 *
 * <p>The tests ensure that:
 * <ul>
 *   <li>The constructor correctly stores the provided values.</li>
 *   <li>Setter methods properly update the field values.</li>
 *   <li>Setters reject blank input by throwing {@link IllegalArgumentException}.</li>
 * </ul>
 */
class AuthorTest {

  /**
   * Verifies that the constructor correctly stores all provided field values.
   */
  @Test
  void whenConstructorStoreValue_constructorShouldStoreAllValuesCorrectly() {
    String firstName = "Shara";
    String lastName = "Johansen";
    String email = "SharaJ@hotmail.com";


    Author entry = new Author(firstName, lastName, email);

    Assertions.assertEquals(firstName, entry.getFirstName());
    Assertions.assertEquals(lastName, entry.getLastName());
    Assertions.assertEquals(email, entry.getEmail());


  }

  /**
   * Tests that all setter methods successfully update the corresponding fields.
   */
  @Test
  void whenSetterMethodsUpdates_settersShouldUpdateFields() {
    Author entry = new Author("Shara", "Johansen", "SharaJ@hotmail.com");

    entry.setFirstName("New firstname");
    entry.setLastName("New lastname");
    entry.setEmail("New email");
    Assertions.assertEquals("New firstname", entry.getFirstName());
    Assertions.assertEquals("New lastname", entry.getLastName());
    Assertions.assertEquals("New email", entry.getEmail());
  }

  /**
   * Ensures that setting a blank first name results in an {@link IllegalArgumentException}.
   */
  @Test
  void whenSettingBlankFirstName_setFirstNameShouldRejectBlankValue() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    Assertions.assertThrows(IllegalArgumentException.class, () -> entry.setFirstName(""));
  }

  /**
   * Ensures that setting a blank last name results in an {@link IllegalArgumentException}.
   */
  @Test
  void whenSettingBlankLastName_setLastNameShouldRejectBlankValue() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    Assertions.assertThrows(IllegalArgumentException.class, () -> entry.setLastName(""));
  }

  /**
   * Ensures that setting a blank email results in an {@link IllegalArgumentException}.
   */
  @Test
  void whenSettingBlankEmail_setEmailShouldRejectBlankValue() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    Assertions.assertThrows(IllegalArgumentException.class, () -> entry.setEmail(""));
  }
}
