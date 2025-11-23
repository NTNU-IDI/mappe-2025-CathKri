package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthorTest {

  @Test
  void constructorStoresAllValue() {
    String fornavn = "Shara";
    String etternavn = "Johansen";
    String email = "SharaJ@hotmail.com";


    Author entry = new Author(fornavn, etternavn, email);

    assertEquals(fornavn, entry.getFirstName());
    assertEquals(etternavn, entry.getLastName());
    assertEquals(email, entry.getEmail());


  }

  @Test
  void settersUpdateTekst() {
    Author entry = new Author("Shara", "Johansen", "SharaJ@hotmail.com");

    entry.setFirstName("New Fornavn");
    entry.setLastName("New Etternavn");
    entry.setEmail("New email");
    assertEquals("New Fornavn", entry.getFirstName());
    assertEquals("New Etternavn", entry.getLastName());
    assertEquals("New email", entry.getEmail());
  }

  @Test
  void setterRejectsBlankFornavn() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setFirstName(""));
  }

  @Test
  void setterRejectsBlankEtternavn() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setLastName(""));
  }

  @Test
  void setterRejectsBlankEmail() {
    Author entry = new Author("", "Johansen", "SharaJ@hotmail.com");
    assertThrows(IllegalArgumentException.class, () -> entry.setEmail(""));
  }
}
