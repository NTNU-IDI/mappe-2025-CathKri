package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link DiaryEntryRegister}.
 * <p>
 * This class verifies core functionality of the DiaryEntryRegister component, including:
 * <ul>
 *     <li>Initialization of the internal diary entry list</li>
 *     <li>Adding diary entries, including null handling</li>
 *     <li>Searching for diary entries containing a specific word in their text</li>
 *     <li>Searching for diary entries within a specific date range</li>
 *     <li>Deleting diary entries based on entry ID</li>
 * </ul>
 * <p>
 * Assertions from JUnit 5 are used to validate expected behavior.
 */
class DiaryEntryRegisterTest {

  /**
   * Verifies that the constructor initializes an empty list of diary entries.
   */
  @Test
  void whenListIsEmty_constructorInitializesEmtyList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    assertNotNull(register.getAllDiaryEntries());
    assertTrue(register.getAllDiaryEntries().isEmpty());
  }

  /**
   * Tests that adding a null value diary entry, still results in the internal list being updated.
   * Current implementation accepts and stores null entries.
   */
  @Test
  void whenAddingNull_StillAddingDiaryEntryInList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    register.addDiaryEntry(null);

    assertFalse(register.getAllDiaryEntries().isEmpty());
  }

  /**
   * Ensures that the register correctly returns all diary entries containing a specific word
   * in their text content.
   * <p>
   * Only entries where the body text contains the searched word should be returned.
   */
  @Test
  void FindAndReturnRegisteredDiaryEntryBasedOnWord() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    DiaryEntry Entry1 = new DiaryEntry(5, new Author("Shara", "Johansen", "SharaJ@hotmail.com"), LocalDateTime.now(), "title", "I jogged today.");
    DiaryEntry Entry2 = new DiaryEntry(6,new Author("Mike", "Thomsen", "MT@hotmail.com"), LocalDateTime.now(), "title", "tekst");
    DiaryEntry Entry3 = new DiaryEntry(7, new Author("Tom", "Thomason", "TT@hotmail.com"),LocalDateTime.now(), "title", "tekst");

    register.addDiaryEntry(Entry1);
    register.addDiaryEntry(Entry2);
    register.addDiaryEntry(Entry3);

    List<DiaryEntry> results = register.findAllDiaryEntriesBasedOnWord("jogged");

    assertNotNull(results);
    assertTrue(results.contains(Entry1));
    assertFalse(results.contains(Entry2));
    assertFalse(results.contains(Entry3));
  }

  /**
   * Ensures that the register correctly returns all diary entries containing a specific word
   * in their text content.
   * <p>
   * Only entries where the body text contains the searched word should be returned.
   */
  @Test
  void findAndReturnRegisteredDiaryEntryBasedOnDate() {
    DiaryEntryRegister register = new DiaryEntryRegister();

    LocalDateTime fromDate = LocalDateTime.now().minusDays(10);
    LocalDateTime toDate = LocalDateTime.now().plusDays(10);

    DiaryEntry entry1 = new DiaryEntry(5, new Author("Shara", "Johansen", "SharaJ@hotmail.com"), LocalDateTime.now().minusDays(5), "title", "tekst");
    DiaryEntry entry2 = new DiaryEntry(6, new Author("Mike", "Thomsen", "MT@hotmail.com"), LocalDateTime.now().plusDays(5), "title", "tekst");
    DiaryEntry entry3 = new DiaryEntry(7, new Author("Tom", "Thomasen", "TT@Hotmail.com"), LocalDateTime.now().minusDays(30), "title", "tekst");

    register.addDiaryEntry(entry1);
    register.addDiaryEntry(entry2);
    register.addDiaryEntry(entry3);

    List<DiaryEntry> results = register.findRegisteredDiaryEntriesBasedOnDate(fromDate, toDate);

    assertEquals(2, results.size());
    assertTrue(results.contains(entry1));
    assertTrue(results.contains(entry2));
    assertFalse(results.contains(entry3));

  }

  /**
   * Tests that deleting a diary entry by ID removes the correct entry from the register.
   * <p>
   * Ensures that entries not matching the ID remain in the list.
   */
  @Test
  void deleteRemoveEntry() {
    DiaryEntryRegister DiaryEntryRegister = new DiaryEntryRegister();
    DiaryEntry entry1 = new DiaryEntry(5, new Author("Shara", "Johansen", "SharaJ@hotmail.com"), LocalDateTime.now().minusDays(5), "title", "tekst");
    DiaryEntry entry2 = new DiaryEntry(6, new Author("Mike", "Thomsen", "MT@hotmail.com"), LocalDateTime.now().plusDays(5), "title", "tekst");

    DiaryEntryRegister.addDiaryEntry(entry1);
    DiaryEntryRegister.addDiaryEntry(entry2);

    DiaryEntryRegister.DeleteDiaryEntry(DiaryEntryRegister, 2);

    assertEquals(2, DiaryEntryRegister.getAllDiaryEntries().size());
    assertFalse(DiaryEntryRegister.getAllDiaryEntries().stream().anyMatch(entry -> entry.getId() == 1));

  }

}
