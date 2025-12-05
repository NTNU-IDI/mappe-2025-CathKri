package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link DiaryEntry}.
 * <p>
 * This class verifies that DiaryEntry objects are correctly created,
 * updated, and validated. The tests cover:
 * <ul>
 *     <li>Constructor behavior and initialization of all fields</li>
 *     <li>Setter methods updating text fields</li>
 *     <li>Validation of required values such as title, content, and timestamp</li>
 *     <li>Automatic updates of the last-modified timestamp when fields change</li>
 * </ul>
 */
class DiaryEntryTest {

  /**
   * Verifies that the constructor correctly stores all provided values
   * and initializes the last-modified timestamp to match the creation timestamp.
   */
  @Test
  void constructorStoresAllValue() {
    int id = 1;
    Author forfatter = new Author("Shara", "Johansen", "Shara@hotmail.com");
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
   * Ensures that setter methods successfully update the title and content fields.
   */
  @Test
  void settersUpdateText() {
    DiaryEntry entry = new DiaryEntry(1, new Author("Shara", "Johansen", "Shara@hotmail.com"), LocalDateTime.now(), "Title", "Content");

    entry.setTitle("New title");
    entry.setContent("New text");
    assertEquals("New title", entry.getTitle());
    assertEquals("New text", entry.getContent());
  }

  /**
   * Verifies that the constructor rejects a null or blank title
   * by throwing an {@link IllegalArgumentException}.
   */
  @Test
  void constructorRejectsBlankTitle() {
    int id = 1;

    assertThrows(IllegalArgumentException.class, () -> new DiaryEntry(1, new Author("Shara", "Johansen", "Shara@hotmail.com"), LocalDateTime.now(), null, "content"));

  }

  /**
   * Ensures that setting blank content results in an
   * {@link IllegalArgumentException}.
   */
  @Test
  void setterRejectsBlankContent() {
    DiaryEntry entry = new DiaryEntry(1, new Author("Shara", "Johansen", "Shara@hotmail.com"), LocalDateTime.now(), "Title", "");
    assertThrows(IllegalArgumentException.class, () -> entry.setContent(""));
  }

  /**
   * Confirms that the constructor rejects a null creation timestamp,
   * since a diary entry must always have a valid creation time.
   */
  @Test
  void constructorRejectsNullCreatedAt() {
    assertThrows(IllegalArgumentException.class, () -> new DiaryEntry(1, new Author("Shara", "Johansen", "Shara@hotmail.com"), null, "Title", "content"));
  }

  /**
   * Tests whether updating the title triggers a change in the
   * last-modified timestamp. This ensures that edits modify
   * the metadata correctly.
   */
  @Test
  void changeTitleUpdateLastEditedAt() {
    DiaryEntry entry = new DiaryEntry(1, new Author("Shara", "Johansen", "Shara@hotmail.com"), LocalDateTime.now(), "Title", "Content");

    LocalDateTime before = entry.getLastModifiedAt();
    entry.setTitle("New title");
    LocalDateTime after = LocalDateTime.now();
    assertEquals(before, after);
  }

}