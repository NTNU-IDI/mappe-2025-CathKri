package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 */
public class AuthorRegister {
  private ArrayList<Author> AuthorsList;

  Logger logger = Logger.getLogger(getClass().getName());

  /**
   *
   */
  public AuthorRegister() {
    AuthorsList = new ArrayList<Author>();
  }

  /**
   *
   * @return
   */
  public ArrayList<Author> getAuthorsList() {
    return AuthorsList;
  }

  /**
   *
   * @param authorsList
   */
  public void setAuthorsList(ArrayList<Author> authorsList) {
    this.AuthorsList = authorsList;
  }

  /**
   *
   * @param firstName
   * @param lastName
   * @return
   */
  public Author findAuthor(String firstName, String lastName) {
    for (Author author : AuthorsList) {
      if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)) {
        return author;
      }
    }
    return null;
  }

  /**
   *
   * @param author
   */
  public void addAuthor(Author author) {
    AuthorsList.add(author);
  }

  /**
   * @param register register.
   * @param author   author.
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

  /**
   *
   * @param register
   * @param authorRegister
   * @return
   */
  public List<AuthorPostCount> createAuthorPostList(DiaryEntryRegister register, AuthorRegister authorRegister) {
    List<AuthorPostCount> list = new ArrayList<>();

    for (Author author : authorRegister.getAuthorsList()) {
      int count = numberOfPostPerAuthor(register, author);
      list.add(new AuthorPostCount(author, count));
    }

    return list;
  }

  /**
   *
   * @param register
   * @param author
   * @return
   */
  public int numberOfPostPerAuthor(DiaryEntryRegister register, Author author) {
    int count = 0;
    for (DiaryEntry diaryEntry : register.getAllDiaryEntries()) {
      if (diaryEntry.getAuthor().equals(author)) {
        count++;
      }
    }
    return count;
  }

  /**
   *
   * @param list
   */
  public void printAuthorPostList(List<AuthorPostCount> list) {
    logger.info("Author\t\tPosts");
    logger.info(" ");

    for (AuthorPostCount item : list) {
      logger.info(item.author().firstName + " " + item.author().lastName + ": " + "\t\t" + item.postCount());
    }
  }
}
