package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiaryEntryRegisterTest {

  @Test
  void constructorInitializesEmtyList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    assertNotNull(register.getAllDiaryEntries());
    assertTrue(register.getAllDiaryEntries().isEmpty());
  }

  @Test
  void addingDiaryEntryInList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    register.addDiaryEntry(null);

    assertFalse(register.getAllDiaryEntries().isEmpty());
  }

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
}
