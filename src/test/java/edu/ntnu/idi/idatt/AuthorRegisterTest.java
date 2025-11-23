package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AuthorRegisterTest {

  @Test
  void constructorInitializesEmtyList() {
    AuthorRegister forfatterRegister = new AuthorRegister();
    assertNotNull(forfatterRegister.getAuthorsList());
    assertTrue(forfatterRegister.getAuthorsList().isEmpty());
  }

  @Test
  void settersShowsForfatterList() {
    AuthorRegister forfatterRegister = new AuthorRegister();
    forfatterRegister.setAuthorsList(null);

    assertNull(forfatterRegister.getAuthorsList());
  }

  @Test
  void finnForfatterInList() {
    AuthorRegister forfatterRegister = new AuthorRegister();
    Author nr1 = new Author("Shara", "Johansen", "SharaJ@hotmail.com");
    Author nr2 = new Author("Tom", "Eriksen", "tom@hotmail.com");
    forfatterRegister.addAuthor(nr1);
    forfatterRegister.addAuthor(nr2);

    assertEquals(2, forfatterRegister.getAuthorsList().size());
  }

  @Test
  void addingForfatterInList() {
    AuthorRegister forfatterRegister = new AuthorRegister();
    forfatterRegister.addAuthor(null);

    assertFalse(forfatterRegister.getAuthorsList().isEmpty());
  }

  @Test
  void findAndReturnAllDiaryEntrysFromAuthorInList() {
    DiaryEntryRegister dagbokinnleggRegister = new DiaryEntryRegister();
    Author forfatter1 = new Author("Tom", "Jones", "TJ@hotmail.com");
    Author forfatter2 = new Author("Finn", "Finnsnes", "FF@hotmail.com");
    DiaryEntry innlegg1 = new DiaryEntry(5, forfatter1, LocalDateTime.now(), "tittel", "tekst");
    DiaryEntry innlegg2 = new DiaryEntry(6, forfatter2, LocalDateTime.now(), "tittel", "tekst");
    DiaryEntry innlegg3 = new DiaryEntry(7, forfatter1, LocalDateTime.now(), "tittel", "tekst");
    dagbokinnleggRegister.addDiaryEntry(innlegg1);
    dagbokinnleggRegister.addDiaryEntry(innlegg2);
    dagbokinnleggRegister.addDiaryEntry(innlegg3);

    AuthorRegister forfatterRegister = new AuthorRegister();
    forfatterRegister.addAuthor(forfatter1);
    forfatterRegister.addAuthor(forfatter2);

    ArrayList<DiaryEntry> antall = (ArrayList<DiaryEntry>) forfatterRegister.findAllDiaryEntriesFromAuthor(dagbokinnleggRegister, forfatter1);

    assertEquals(2, antall.size());
  }

  @Test
  void ReturnerRiktigAntallInnleggPerForfatter() {
    Author forfatter1 = new Author("Tom", "Jones", "TJ@hotmail.com");
    Author forfatter2 = new Author("Finn", "Finnsnes", "FF@hotmail.com");
    DiaryEntry innlegg1 = new DiaryEntry(5, forfatter1, LocalDateTime.now(), "tittel", "tekst");
    DiaryEntry innlegg2 = new DiaryEntry(6, forfatter2, LocalDateTime.now(), "tittel", "tekst");
    DiaryEntry innlegg3 = new DiaryEntry(7, forfatter1, LocalDateTime.now(), "tittel", "tekst");
    DiaryEntryRegister dagbokinnleggRegister = new DiaryEntryRegister();

    dagbokinnleggRegister.addDiaryEntry(innlegg1);
    dagbokinnleggRegister.addDiaryEntry(innlegg2);
    dagbokinnleggRegister.addDiaryEntry(innlegg3);

    AuthorRegister forfatterRegister = new AuthorRegister();
    forfatterRegister.addAuthor(forfatter1);
    forfatterRegister.addAuthor(forfatter2);

    ArrayList<DiaryEntry> antall = (ArrayList<DiaryEntry>) forfatterRegister.findAllDiaryEntriesFromAuthor(dagbokinnleggRegister, forfatter1);
    ArrayList<DiaryEntry> antall2 = (ArrayList<DiaryEntry>) forfatterRegister.findAllDiaryEntriesFromAuthor(dagbokinnleggRegister, forfatter2);

    assertEquals(2, antall.size());
    assertEquals(1, antall2.size());
  }

}
