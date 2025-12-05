package edu.ntnu.idi.idatt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Represents a register for storing and managing {@link DiaryEntry} objects.

 * This class provides functionality to add entries, retrieve all entries,
 * search for entries based on dates or keywords, and delete entries by ID.
 *
 */
public class DiaryEntryRegister {
  private final ArrayList<DiaryEntry> AllDairyEntries;

  Logger logger = Logger.getLogger(getClass().getName());

  /**
   * Creates an empty diary entry register.
   */
  public DiaryEntryRegister() {
    AllDairyEntries = new ArrayList();
  }

  /**
   * Adds a new diary entry to the register.
   *
   * @param diaryEntry the entry to be added
   */
  public void addDiaryEntry(DiaryEntry diaryEntry) {
    AllDairyEntries.add(diaryEntry);
  }

  /**
   * Returns all diary entries stored in the register.
   *
   * @return a list of all diary entries
   */
  public ArrayList<DiaryEntry> getAllDiaryEntries() {

    return AllDairyEntries;
  }

  /**
   * Finds all diary entries within a given date range.
   *
   * @param fromDato the start date/time
   * @param toDato   the end date/time
   * @return a list of diary entries created within the given date range
   */
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

  /**
   * Searches for diary entries containing a given word in their title or content.
   *
   * @param word the search keyword
   * @return a list of diary entries that match the search term,
   *         or an empty list if the search term is null or blank
   */
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

  /**
   * Deletes a diary entry based on its ID.
   *
   * @param register the register containing diary entries
   * @param id       the ID of the entry to delete
   */
  public void DeleteDiaryEntry(DiaryEntryRegister register, int id) {
    DiaryEntry diaryEntryToRemove = null;
    for (DiaryEntry diaryEntry : AllDairyEntries) {
      if (diaryEntry.getId() == id) {
        diaryEntryToRemove = diaryEntry;
        logger.info("DiaryEntry " + id + " has been deleted");
      }
    }
    if (diaryEntryToRemove != null) {
      register.AllDairyEntries.remove(diaryEntryToRemove);
    } else {
      logger.info("DiaryEntry with id: " + id + " not found.");
    }
  }


}

