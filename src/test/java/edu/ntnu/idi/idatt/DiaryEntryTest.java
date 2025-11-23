package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 */
class DiaryEntryTest {
  /**
   *
   */
  @Test
  void constructorStoresAllValue() {
    int id = 1;
    Author forfatter = new Author("Shara","Johansen","Shara@hotmail.com");
    String tittel = "Day one";
    String innhold = "To do list";
    LocalDateTime opprettet = LocalDateTime.now();


    DiaryEntry entry = new DiaryEntry(id, forfatter, opprettet, tittel, innhold);

    assertEquals(id, entry.getId());
    assertEquals(forfatter, entry.getAuthor());
    assertEquals(tittel, entry.getTitle());
    assertEquals(innhold, entry.getContent());
    assertEquals(opprettet, entry.getCreatedAt());
    assertEquals(opprettet, entry.getLastModifiedAt());


  }

  /**
   *
   */
  @Test
  void settersUpdateText() {
    DiaryEntry entry = new DiaryEntry(1, new Author("Shara","Johansen","Shara@hotmail.com"), LocalDateTime.now(), "Title", "Content");

    entry.setTitle("New title");
    entry.setContent("New text");
    assertEquals("New title", entry.getTitle());
    assertEquals("New text", entry.getContent());
  }

  /**
   *
   */
  @Test
  void constructorRejectsBlankTitle() {
    int id = 1;

    assertThrows(IllegalArgumentException.class, () -> new DiaryEntry(1, new Author("Shara","Johansen","Shara@hotmail.com"), LocalDateTime.now(), null, "content"));

  }

  /**
   *
   */
  @Test
  void setterRejectsBlankContent() {
    DiaryEntry entry = new DiaryEntry(1, new Author("Shara","Johansen","Shara@hotmail.com"), LocalDateTime.now(), "Title", "");
    assertThrows(IllegalArgumentException.class, () -> entry.setContent(""));
  }

  /**
   *
   */
  @Test
  void constructorRejectsNullCreatedAt() {
    assertThrows(IllegalArgumentException.class, () -> new DiaryEntry(1, new Author("Shara","Johansen","Shara@hotmail.com"),null, "Title", "content"));
  }

  /**
   * checks if the date changes when updating the title.
   */
  @Test
  void changetitleUpdateLastEditedAt() {
    DiaryEntry entry = new DiaryEntry(1, new Author("Shara","Johansen","Shara@hotmail.com"), LocalDateTime.now(), "Title", "Content");

    LocalDateTime before = entry.getLastModifiedAt();
    entry.setTitle("New title");
    LocalDateTime after = LocalDateTime.now();
    assertEquals(before, after);
  }

}