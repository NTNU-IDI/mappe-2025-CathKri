package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AuthorRegisterTest {

  @Test
  void constructorInitializesEmtyList() {
    AuthorRegister authorRegister = new AuthorRegister();
    assertNotNull(authorRegister.getAuthorsList());
    assertTrue(authorRegister.getAuthorsList().isEmpty());
  }

  @Test
  void settersShowsAuthorList() {
    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.setAuthorsList(null);

    assertNull(authorRegister.getAuthorsList());
  }

  @Test
  void finnAuthorInList() {
    AuthorRegister authorRegister = new AuthorRegister();
    Author nr1 = new Author("Shara", "Johansen", "SharaJ@hotmail.com");
    Author nr2 = new Author("Tom", "Eriksen", "tom@hotmail.com");
    authorRegister.addAuthor(nr1);
    authorRegister.addAuthor(nr2);

    assertEquals(2, authorRegister.getAuthorsList().size());
  }

  @Test
  void addingAuthorInList() {
    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.addAuthor(null);

    assertFalse(authorRegister.getAuthorsList().isEmpty());
  }

  @Test
  void findAndReturnAllDiaryEntrysFromAuthorInList() {
    DiaryEntryRegister diaryEntryRegister = new DiaryEntryRegister();
    Author author1 = new Author("Tom", "Jones", "TJ@hotmail.com");
    Author author2 = new Author("Finn", "Finnsnes", "FF@hotmail.com");
    DiaryEntry entry1 = new DiaryEntry(5, author1, LocalDateTime.now(), "title", "tekst");
    DiaryEntry entry2 = new DiaryEntry(6, author2, LocalDateTime.now(), "title", "tekst");
    DiaryEntry entry3 = new DiaryEntry(7, author1, LocalDateTime.now(), "title", "tekst");
    diaryEntryRegister.addDiaryEntry(entry1);
    diaryEntryRegister.addDiaryEntry(entry2);
    diaryEntryRegister.addDiaryEntry(entry3);

    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.addAuthor(author1);
    authorRegister.addAuthor(author2);

    ArrayList<DiaryEntry> number = (ArrayList<DiaryEntry>) authorRegister.findAllDiaryEntriesFromAuthor(diaryEntryRegister, author1);

    assertEquals(2, number.size());
  }

  @Test
  void ReturnRightNumberOfDiaryEntriesPerAuthor() {
    Author author1 = new Author("Tom", "Jones", "TJ@hotmail.com");
    Author author2 = new Author("Finn", "Finnsnes", "FF@hotmail.com");
    DiaryEntry entry1 = new DiaryEntry(5, author1, LocalDateTime.now(), "title", "tekst");
    DiaryEntry entry2 = new DiaryEntry(6, author2, LocalDateTime.now(), "title", "tekst");
    DiaryEntry entry3 = new DiaryEntry(7, author1, LocalDateTime.now(), "title", "tekst");
    DiaryEntryRegister diaryEntryRegister = new DiaryEntryRegister();

    diaryEntryRegister.addDiaryEntry(entry1);
    diaryEntryRegister.addDiaryEntry(entry2);
    diaryEntryRegister.addDiaryEntry(entry3);

    AuthorRegister authorRegister = new AuthorRegister();
    authorRegister.addAuthor(author1);
    authorRegister.addAuthor(author2);

    ArrayList<DiaryEntry> number1 = (ArrayList<DiaryEntry>) authorRegister.findAllDiaryEntriesFromAuthor(diaryEntryRegister, author1);
    ArrayList<DiaryEntry> number2 = (ArrayList<DiaryEntry>) authorRegister.findAllDiaryEntriesFromAuthor(diaryEntryRegister, author2);

    assertEquals(2, number1.size());
    assertEquals(1, number2.size());
  }

}
