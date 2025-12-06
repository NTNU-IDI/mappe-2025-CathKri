package edu.ntnu.idi.idatt.register;

import edu.ntnu.idi.idatt.model.Author;
import edu.ntnu.idi.idatt.model.DiaryEntry;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link DiaryEntryRegister}.
 *
 * <p>This class verifies core functionality of the DiaryEntryRegister component, including:
 * <ul>
 *     <li>Initialization of the internal diary entry list</li>
 *     <li>Adding diary entries, including null handling</li>
 *     <li>Searching for diary entries containing a specific word in their text</li>
 *     <li>Searching for diary entries within a specific date range</li>
 *     <li>Deleting diary entries based on entry ID</li>
 * </ul>
 * Assertions from JUnit 5 are used to validate expected behavior.
 */
class DiaryEntryRegisterTest {

  /**
   * Verifies that the constructor initializes an empty list of diary entries.
   */
  @Test
  void whenListIsEmpty_constructorInitializesEmptyList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    Assertions.assertNotNull(register.getAllDiaryEntries());
    Assertions.assertTrue(register.getAllDiaryEntries().isEmpty());
  }

  /**
   * Tests that adding a null value diary entry, still results in the internal list being updated.
   * Current implementation accepts and stores null entries.
   */
  @Test
  void whenAddingNull_stillAddingDiaryEntryInList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    register.addDiaryEntry(null);

    Assertions.assertFalse(register.getAllDiaryEntries().isEmpty());
  }

  /**
   * Ensures that the register correctly returns all diary entries containing a specific word
   * in their text content.
   *
   * <p>Only entries where the body text contains the searched word should be returned.
   */
  @Test
  void findAndReturnRegisteredDiaryEntryBasedOnWord() {
    DiaryEntryRegister register = new DiaryEntryRegister();

    DiaryEntry entry1 = new DiaryEntry(5, new Author(
        "Shara", "Johansen", "SharaJ@hotmail.com"),
        LocalDateTime.now(), "title", "I jogged today.");

    DiaryEntry entry2 = new DiaryEntry(6, new Author(
        "Mike", "Thomsen", "MT@hotmail.com"),
        LocalDateTime.now(), "title", "tekst");

    DiaryEntry entry3 = new DiaryEntry(7, new Author(
        "Tom", "Thomason", "TT@hotmail.com"),
        LocalDateTime.now(), "title", "tekst");

    register.addDiaryEntry(entry1);
    register.addDiaryEntry(entry2);
    register.addDiaryEntry(entry3);

    List<DiaryEntry> results = register.findAllDiaryEntriesBasedOnWord("jogged");

    Assertions.assertNotNull(results);
    Assertions.assertTrue(results.contains(entry1));
    Assertions.assertFalse(results.contains(entry2));
    Assertions.assertFalse(results.contains(entry3));
  }

  /**
   * Ensures that the register correctly returns all diary entries containing a specific word
   * in their text content.
   *
   * <p>Only entries where the body text contains the searched word should be returned.
   */
  @Test
  void findAndReturnRegisteredDiaryEntryBasedOnDate() {
    DiaryEntryRegister register = new DiaryEntryRegister();

    LocalDateTime fromDate = LocalDateTime.now().minusDays(10);
    LocalDateTime toDate = LocalDateTime.now().plusDays(10);

    DiaryEntry entry1 = new DiaryEntry(5, new Author(
        "Shara", "Johansen", "SharaJ@hotmail.com"),
        LocalDateTime.now().minusDays(5), "title", "tekst");

    DiaryEntry entry2 = new DiaryEntry(6, new Author(
        "Mike", "Thomsen", "MT@hotmail.com"),
        LocalDateTime.now().plusDays(5), "title", "tekst");

    DiaryEntry entry3 = new DiaryEntry(7, new Author(
        "Tom", "Thomasen", "TT@Hotmail.com"),
        LocalDateTime.now().minusDays(30), "title", "tekst");

    register.addDiaryEntry(entry1);
    register.addDiaryEntry(entry2);
    register.addDiaryEntry(entry3);

    List<DiaryEntry> results = register.findRegisteredDiaryEntriesBasedOnDate(fromDate, toDate);

    Assertions.assertEquals(2, results.size());
    Assertions.assertTrue(results.contains(entry1));
    Assertions.assertTrue(results.contains(entry2));
    Assertions.assertFalse(results.contains(entry3));

  }

  /**
   * Tests that deleting a diary entry by ID removes the correct entry from the register.
   *
   * <p>Ensures that entries not matching the ID remain in the list.
   */
  @Test
  void deleteRemoveEntry() {
    DiaryEntryRegister diaryEntryRegister = new DiaryEntryRegister();

    DiaryEntry entry1 = new DiaryEntry(5, new Author(
        "Shara", "Johansen", "SharaJ@hotmail.com"),
        LocalDateTime.now().minusDays(5), "title", "tekst");

    DiaryEntry entry2 = new DiaryEntry(6, new Author(
        "Mike", "Thomsen", "MT@hotmail.com"),
        LocalDateTime.now().plusDays(5), "title", "tekst");

    diaryEntryRegister.addDiaryEntry(entry1);
    diaryEntryRegister.addDiaryEntry(entry2);

    diaryEntryRegister.deleteDiaryEntry(diaryEntryRegister, 2);

    Assertions.assertEquals(2, diaryEntryRegister.getAllDiaryEntries().size());
    Assertions.assertFalse(
        diaryEntryRegister.getAllDiaryEntries().stream().anyMatch(entry -> entry.getId() == 1));
  }

}
