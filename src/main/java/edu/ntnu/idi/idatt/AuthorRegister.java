package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AuthorRegister {
  private ArrayList<Author> AuthorsList;

  public AuthorRegister() {
    AuthorsList = new ArrayList<Author>();
  }

  public ArrayList<Author> getAuthorsList() {
    return AuthorsList;
  }

  public void setAuthorsList(ArrayList<Author> authorsList) {
    this.AuthorsList = authorsList;
  }

  public Author findAuthor(String firstName, String lastName) {
    for (Author author : AuthorsList) {
      if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)) {
        return author;
      }
    }
    return null;
  }

  public void addAuthor(Author author) {
    AuthorsList.add(author);
  }

  /**
   * @param register register.
   * @param author author.
   * @return allDiaryEntries.
   */
  public List<DiaryEntry> findAllDiaryEntriesFromAuthor(DiaryEntryRegister register, Author author) {
    ArrayList<DiaryEntry> DiaryEntryList = register.getAllDiaryEntries();
    ArrayList<DiaryEntry> allDiaryEntries = new ArrayList<>();
    for (DiaryEntry DiaryEntry : DiaryEntryList) {
      if (DiaryEntry.getAuthor().equals(author)) {
        allDiaryEntries.add(DiaryEntry);
      }
    }
    return allDiaryEntries;
  }

  public int numberOfPostPerAuthor(DiaryEntryRegister register, Author author) {
    return findAllDiaryEntriesFromAuthor(register, author).size();
  }


}
