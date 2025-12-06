package edu.ntnu.idi.idatt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link AuthorRegister}.
 *
 * <p>This class contains unit tests verifying core functionality of the
 * AuthorRegister component, including:
 * <ul>
 *     <li>Initialization of the internal author list</li>
 *     <li>Setter behavior for the author list</li>
 *     <li>Adding authors to the register</li>
 *     <li>Retrieving entries associated with a specific author</li>
 *     <li>Counting diary entries per author</li>
 * </ul>
 * The tests use JUnit 5 assertions to validate expected outcomes.
 */
class AuthorRegisterTest {

  /**
   * Verifies that the constructor initializes an empty author list.
   */
  @Test
  void constructor_whenCalled_initializesEmptyAuthorList() {
    AuthorRegister authorRegister = new AuthorRegister();
    Assertions.assertNotNull(authorRegister.getAuthorsList());
    Assertions.assertTrue(authorRegister.getAuthorsList().isEmpty());
  }

  /**
   * Tests that the setter allows the internal author list to be replaced.
   * In this case, verifies that setting it to null is accepted.
   */
  @Test
  void setAuthorsList_whenSetToNull_listBecomesNull() {
    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.setAuthorsList(null);

    Assertions.assertNull(authorRegister.getAuthorsList());
  }

  /**
   * Ensures that authors added to the register are correctly stored.
   * Adds two authors and checks that the list size increases accordingly.
   */
  @Test
  void addAuthor_whenAuthorsAdded_listContainsAllAuthors() {
    AuthorRegister authorRegister = new AuthorRegister();
    Author nr1 = new Author("Shara", "Johansen", "SharaJ@hotmail.com");
    Author nr2 = new Author("Tom", "Eriksen", "tom@hotmail.com");

    authorRegister.addAuthor(nr1);
    authorRegister.addAuthor(nr2);

    Assertions.assertEquals(2, authorRegister.getAuthorsList().size());
  }

  /**
   * Tests adding a null author to the register.
   * The current implementation still inserts the value,
   * therefore the list should not remain empty.
   */
  @Test
  void addAuthor_whenNullAuthorAdded_listStillUpdates() {
    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.addAuthor(null);

    Assertions.assertFalse(authorRegister.getAuthorsList().isEmpty());
  }

  /**
   * Verifies that the register correctly returns all diary entries
   * matching a specific author.
   */
  @Test
  void findAllDiaryEntriesFromAuthor_whenEntriesExist_returnsMatchingEntries() {
    DiaryEntryRegister diaryEntryRegister = new DiaryEntryRegister();
    Author author1 = new Author("Tom", "Jones", "TJ@hotmail.com");
    Author author2 = new Author("Finn", "Finnsnes", "FF@hotmail.com");

    DiaryEntry entry1 = new DiaryEntry(
        5, author1, LocalDateTime.now(), "title", "tekst"
    );
    DiaryEntry entry2 = new DiaryEntry(
        6, author2, LocalDateTime.now(), "title", "tekst"
    );
    DiaryEntry entry3 = new DiaryEntry(
        7, author1, LocalDateTime.now(), "title", "tekst"
    );

    diaryEntryRegister.addDiaryEntry(entry1);
    diaryEntryRegister.addDiaryEntry(entry2);
    diaryEntryRegister.addDiaryEntry(entry3);

    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.addAuthor(author1);
    authorRegister.addAuthor(author2);

    ArrayList<DiaryEntry> result =
        (ArrayList<DiaryEntry>) authorRegister.findAllDiaryEntriesFromAuthor(
            diaryEntryRegister, author1);

    Assertions.assertEquals(2, result.size());
  }

  /**
   * Tests that the correct number of diary entries is counted per author.
   * One author has two entries, the other has one.
   */
  @Test
  void numberOfEntriesPerAuthor_whenMultipleAuthors_returnsCorrectCounts() {
    Author author1 = new Author("Tom", "Jones", "TJ@hotmail.com");
    Author author2 = new Author("Finn", "Finnsnes", "FF@hotmail.com");

    DiaryEntry entry1 = new DiaryEntry(
        5, author1, LocalDateTime.now(), "title", "tekst"
    );
    DiaryEntry entry2 = new DiaryEntry(
        6, author2, LocalDateTime.now(), "title", "tekst"
    );
    DiaryEntry entry3 = new DiaryEntry(
        7, author1, LocalDateTime.now(), "title", "tekst"
    );

    DiaryEntryRegister diaryEntryRegister = new DiaryEntryRegister();
    diaryEntryRegister.addDiaryEntry(entry1);
    diaryEntryRegister.addDiaryEntry(entry2);
    diaryEntryRegister.addDiaryEntry(entry3);

    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.addAuthor(author1);
    authorRegister.addAuthor(author2);

    ArrayList<DiaryEntry> author1Entries =
        (ArrayList<DiaryEntry>) authorRegister.findAllDiaryEntriesFromAuthor(
            diaryEntryRegister, author1);

    ArrayList<DiaryEntry> author2Entries =
        (ArrayList<DiaryEntry>) authorRegister.findAllDiaryEntriesFromAuthor(
            diaryEntryRegister, author2);

    Assertions.assertEquals(2, author1Entries.size());
    Assertions.assertEquals(1, author2Entries.size());
  }
}
