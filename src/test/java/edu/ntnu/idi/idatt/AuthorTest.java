package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for verifying the functionality of the {@link Author} class.
 * <p>
 * The tests ensure that:
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
    String LastName = "Johansen";
    String email = "SharaJ@hotmail.com";


    Author entry = new Author(firstName, LastName, email);

    assertEquals(firstName, entry.getFirstName());
    assertEquals(LastName, entry.getLastName());
    assertEquals(email, entry.getEmail());


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
    assertEquals("New firstname", entry.getFirstName());
    assertEquals("New lastname", entry.getLastName());
    assertEquals("New email", entry.getEmail());
  }

  /**
   * Ensures that setting a blank first name results in an {@link IllegalArgumentException}.
   */
  @Test
  void whenSettingBlankFirstName_setFirstNameShouldRejectBlankValue() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setFirstName(""));
  }

  /**
   * Ensures that setting a blank last name results in an {@link IllegalArgumentException}.
   */
  @Test
  void whenSettingBlankLastName_setLastNameShouldRejectBlankValue() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setLastName(""));
  }

  /**
   * Ensures that setting a blank email results in an {@link IllegalArgumentException}.
   */
  @Test
  void whenSettingBlankEmail_setEmailShouldRejectBlankValue() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setEmail(""));
  }
}
