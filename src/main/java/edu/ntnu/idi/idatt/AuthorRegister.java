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

  public List<AuthorPostCount> createAuthorPostList(DiaryEntryRegister register, AuthorRegister authorRegister) {
    List<AuthorPostCount> list = new ArrayList<>();

    for (Author author : authorRegister.getAuthorsList()) {
      int count = numberOfPostPerAuthor(register, author);
      list.add(new AuthorPostCount(author, count));
    }

    return list;
  }

  public int numberOfPostPerAuthor(DiaryEntryRegister register, Author author) {
    int count = 0;
    for (DiaryEntry diaryEntry : register.getAllDiaryEntries()) {
      if (diaryEntry.getAuthor().equals(author)) {
        count++;
      }
    }
    return count;
  }

  public void printAuthorPostList(List<AuthorPostCount> list) {
    System.out.println("Author\t\tPosts");
    System.out.println("--------------------------");

    for (AuthorPostCount item : list) {
      System.out.println(item.author().firstName + " " + item.author().lastName + ": " + "\t\t" + item.postCount());
    }
  }
}
