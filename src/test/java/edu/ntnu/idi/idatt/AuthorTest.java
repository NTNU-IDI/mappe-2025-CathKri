package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthorTest {

  @Test
  void constructorStoresAllValue() {
    String firstName = "Shara";
    String LastName = "Johansen";
    String email = "SharaJ@hotmail.com";


    Author entry = new Author(firstName, LastName, email);

    assertEquals(firstName, entry.getFirstName());
    assertEquals(LastName, entry.getLastName());
    assertEquals(email, entry.getEmail());


  }

  @Test
  void settersUpdateTekst() {
    Author entry = new Author("Shara", "Johansen", "SharaJ@hotmail.com");

    entry.setFirstName("New firstname");
    entry.setLastName("New lastname");
    entry.setEmail("New email");
    assertEquals("New firstname", entry.getFirstName());
    assertEquals("New lastname", entry.getLastName());
    assertEquals("New email", entry.getEmail());
  }

  @Test
  void setterRejectsBlankFirstName() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setFirstName(""));
  }

  @Test
  void setterRejectsBlankLastName() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setLastName(""));
  }

  @Test
  void setterRejectsBlankEmail() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setEmail(""));
  }
}
