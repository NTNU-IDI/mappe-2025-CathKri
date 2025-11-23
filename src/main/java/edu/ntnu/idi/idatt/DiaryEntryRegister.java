package edu.ntnu.idi.idatt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaryEntryRegister {
  private final ArrayList<DiaryEntry> AllDairyEntries;

  public DiaryEntryRegister() {
    AllDairyEntries = new ArrayList();
  }

  public void addDiaryEntry(DiaryEntry diaryEntry) {
    AllDairyEntries.add(diaryEntry);
  }

  public ArrayList<DiaryEntry> getAllDiaryEntries() {
    return AllDairyEntries;
  }

  public void findAllRegisteredDiaryEntries() {
    ArrayList<DiaryEntry> allDairyEntries = this.AllDairyEntries;
    for (DiaryEntry diaryEntry : allDairyEntries) {
      System.out.println(diaryEntry.toString());
    }
  }

  public List<DiaryEntry> findRegisteredDiaryEntriesBasedOnDate(LocalDateTime fromDato, LocalDateTime toDato) {
    List<DiaryEntry> resultsList = new ArrayList<>();

    for (DiaryEntry diaryEntry : AllDairyEntries) {
      LocalDateTime createdAt = diaryEntry.getCreatedAt();

      if ((createdAt.isEqual(fromDato) || createdAt.isAfter(fromDato)) &&
          (createdAt.isEqual(toDato) || createdAt.isBefore(toDato))) {

        resultsList.add(diaryEntry);
      }
    }
    return resultsList;
  }

  public ArrayList<DiaryEntry> findAllDiaryEntriesBasedOnWord(String word) {
    ArrayList<DiaryEntry> resultsList = new ArrayList<>();

    if (word == null || word.isBlank()) {
      return resultsList;
    }

    String searchTerm = word.toLowerCase();

    for (DiaryEntry diaryEntry : AllDairyEntries) {
      String title = diaryEntry.getTitle();
      String content = diaryEntry.getContent();

      if ((title != null && title.toLowerCase().contains(searchTerm)) ||
          (content != null && content.toLowerCase().contains(searchTerm))) {

        resultsList.add(diaryEntry);
      }
    }

    return resultsList;

  }

  public void DeleteDiaryEntry(DiaryEntryRegister register, int id) {
    DiaryEntry diaryEntryToRemove = null;
    for (DiaryEntry diaryEntry : AllDairyEntries) {
      if (diaryEntry.getId() == id) {
        diaryEntryToRemove = diaryEntry;
        System.out.println("DiaryEntry " + id + " has been deleted");
      }
    }
    if (diaryEntryToRemove != null) {
      register.AllDairyEntries.remove(diaryEntryToRemove);
    } else {
      System.out.println("DiaryEntry with id: " + id + " not found.");
    }
  }


}

