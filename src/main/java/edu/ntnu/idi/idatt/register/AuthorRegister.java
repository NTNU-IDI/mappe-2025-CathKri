package edu.ntnu.idi.idatt.register;

import edu.ntnu.idi.idatt.model.Author;
import edu.ntnu.idi.idatt.model.AuthorPostCount;
import edu.ntnu.idi.idatt.model.DiaryEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Represents a register for managing {@link Author} objects.
 * This class provides functionality for storing authors, searching for authors,
 * and generating statistics about diary entries written by each author.
 */
public class AuthorRegister {
  Logger logger = Logger.getLogger(getClass().getName());
  private List<Author> authorsList;

  /**
   * Creates a new, empty author register.
   */
  public AuthorRegister() {
    authorsList = new ArrayList<>();
  }

  /**
   * Returns the list of all registered authors.
   *
   * @return a list containing all authors in the register
   */
  public List<Author> getAuthorsList() {
    return authorsList;
  }

  /**
   * Replaces the current list of authors with a new list.
   *
   * @param authorsList the new list of authors
   */
  public void setAuthorsList(List<Author> authorsList) {
    this.authorsList = authorsList;
  }

  /**
   * Finds an author based on first and last name.
   *
   * @param firstName the author's first name
   * @param lastName  the author's last name
   * @return the matching {@link Author}, or {@code null} if not found
   */
  public Author findAuthor(String firstName, String lastName) {
    for (Author author : authorsList) {
      if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)) {
        return author;
      }
    }
    return null;
  }

  /**
   * Adds a new author to the register.
   *
   * @param author the author to add
   */
  public void addAuthor(Author author) {
    authorsList.add(author);
  }

  /**
   * Returns all diary entries written by a specific author.
   *
   * @param register the diary entry register to search in
   * @param author   the author whose entries should be retrieved
   * @return a list of all diary entries belonging to the given author
   */
  public List<DiaryEntry> findAllDiaryEntriesFromAuthor(
      DiaryEntryRegister register, Author author) {
    List<DiaryEntry> diaryEntryList = register.getAllDiaryEntries();
    ArrayList<DiaryEntry> allDiaryEntries = new ArrayList<>();
    for (DiaryEntry diaryEntry : diaryEntryList) {
      if (diaryEntry.getAuthor().equals(author)) {
        allDiaryEntries.add(diaryEntry);
      }
    }
    return allDiaryEntries;
  }


  /**
   * Creates a list showing how many posts each author has written.
   *
   * <p>NOTE: The implementation of {@code createAuthorPostList} was developed
   *   with assistance from ChatGPT.
   *   The logic was reviewed and integrated into the project by the author.</p>
   *
   * @param register       the diary entry register containing entries
   * @param authorRegister the register containing authors
   * @return a list of {@link AuthorPostCount} describing posts per author
   */
  public List<AuthorPostCount> createAuthorPostList(
      DiaryEntryRegister register, AuthorRegister authorRegister) {
    List<AuthorPostCount> list = new ArrayList<>();

    for (Author author : authorRegister.getAuthorsList()) {
      int count = numberOfPostPerAuthor(register, author);
      list.add(new AuthorPostCount(author, count));
    }

    return list;
  }

  /**
   * Counts how many diary entries a specific author has written.
   *
   * @param register the diary entry register to search in
   * @param author   the author whose posts should be counted
   * @return the number of diary entries written by the author
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
   * Prints a list of authors and their associated post counts using the logger.
   *
   * @param list a list of {@link AuthorPostCount} records
   */
  public void printAuthorPostList(List<AuthorPostCount> list) {
    logger.info("Author\t\tPosts");
    logger.info(" ");

    for (AuthorPostCount item : list) {
      logger.info(item.author().getFirstName() + " "
          + item.author().getLastName() + ": " + "\t\t" + item.postCount());
    }
  }
}
