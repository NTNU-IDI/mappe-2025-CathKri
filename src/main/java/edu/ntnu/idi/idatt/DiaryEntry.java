package edu.ntnu.idi.idatt;

import java.time.LocalDateTime;

/**
 * This class represents a diary entry.
 * It holds the information from a client day by day.
 * It asks for the id, date, title and content.
 *
 * @author Cathrine Kristiansen
 * @version 1.0
 * @since 2025-10-12
 */

/**
 * private final int id: The id is only set once and does not change
 * private finale LocalDate date: date are set when creating posts, created once and does not change
 * private final LocalTime time: time are set when creating posts, created once and does not change
 * private String title: tile is a tekst.
 * private String content: content is a tekst.
 */
public class DiaryEntry {
  private final int id;
  private final Author author;
  private final LocalDateTime createdAt;
  private String title;
  private String content;
  private LocalDateTime lastModifiedAt;


  /**
   * This is the constructor for diary entry.
   * It takes the parameters id, title and content.
   * It also sets the date to today's date.
   *
   * @param id        id of the entry (can not be blank)
   * @param title    title of the entry (can not be blank)
   * @param content   content of the entry (can not be blank)
   * @param author author
   *
   */
  public DiaryEntry(int id, Author author, LocalDateTime createdAt, String title, String content) {
    if (title == null) {
      throw new IllegalArgumentException("Title are missing");
    }
    if (content == null) {
      throw new IllegalArgumentException("Content are missing");
    }
    if (createdAt == null) {
      throw new IllegalArgumentException("Creation date and time are missing");
    }
    this.id = id;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.lastModifiedAt = createdAt;
    this.author = author;
  }


  /**
   * Finding input id.
   *
   * @return Id
   */
  public int getId() {
    return id;
  }

  /**
   * @return formater
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * Takes the today's date and time of the entry.
   *
   * @return date and time
   */
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Takes the title of the entry.
   *
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the entry.
   *
   * @param title title
   * @throws IllegalArgumentException if the title shows blank
   */
  public void setTitle(String title) {
    if (title == null) {
      throw new IllegalArgumentException("Title can not be null");
    }
    this.title = title;
    this.lastModifiedAt = createdAt;
  }

  /**
   * Takes the content of the entry.
   *
   * @return content
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets the content of the entry.
   *
   * @param content content
   * @throws IllegalArgumentException if the content is blank.
   */
  public void setContent(String content) {
    if (content.isEmpty()) {
      throw new IllegalArgumentException("Content can not be null");
    }
    this.content = content;
    this.lastModifiedAt = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "DiaryEntry{"
        + " id=" + id
        + " , Author=" + author.getFirstName() + " " + author.getLastName()
        + ", Created at=" + createdAt
        + ", Title='" + title + '\''
        + ", Content='" + content + '\''
        + ", Last modified at=" + lastModifiedAt
        + '}';
  }
}
