package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryEntryRegisterTest {

  @Test
  void constructorInitializesEmtyList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    assertNotNull(register.getAllDiaryEntries());
    assertTrue(register.getAllDiaryEntries().isEmpty());
  }

  @Test
  void addingDagbokinnleggInList() {
    DiaryEntryRegister register = new DiaryEntryRegister();
    register.addDiaryEntry(null);

    assertFalse(register.getAllDiaryEntries().isEmpty());
  }

  @Test
  void FindAndReturnRegistrerteDagbokinnleggBasertPÅOrd() {

  }

  @Test
  void findAndReturnRegistrerteDagbokinnleggBasertPåDato(){

  }
}
