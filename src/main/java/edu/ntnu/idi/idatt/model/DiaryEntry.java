package edu.ntnu.idi.idatt.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class represents a diary entry.
 * It holds the information from a client day by day.
 * It asks for the id, author, create timestamps, title and content.
 * The entry also stores the last time it was modified.
 *
 * @author Cathrine Kristiansen
 * @since 2025-10-12
 */
public class DiaryEntry {
  private final int id;
  private final Author author;
  private final LocalDateTime createdAt;
  private String title;
  private String content;
  private LocalDateTime lastModifiedAt;


  /**
   * Creates a new diary entry with the given parameters.
   *
   * @param id         the unique ID of the entry
   * @param author     the author who created the entry
   * @param createdAt  the timestamp when the entry was created (can not be null)
   * @param title      the title of the entry (can not be blank)
   * @param content    the content of the entry (can not be blank)
   *
   * @throws IllegalArgumentException if title, content, or createdAt is blank or null.
   */
  public DiaryEntry(int id, Author author, LocalDateTime createdAt, String title, String content) {
    if (Objects.equals(title, "")) {
      throw new IllegalArgumentException("Title are missing");
    }
    if (Objects.equals(content, "")) {
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
   * Returns the ID of this diary entry.
   *
   * @return the entry ID
   */
  public int getId() {
    return id;
  }

  /**
   * Returns the author who created the diary entry.
   *
   * @return the author of the entry
   */
  public Author getAuthor() {
    return author;
  }

  /**
   * Returns the timestamp when the entry was created.
   *
   * @return the creation date and time
   */
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * Returns the timestamp when the entry was last modified.
   *
   * @return the last modification timestamp
   */
  public LocalDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  /**
   * Returns the title of the diary entry.
   *
   * @return the title text
   */
  public String getTitle() {
    return title;
  }

  /**
   * Updates the title of the diary entry.
   *
   * @param title the new title
   * @throws IllegalArgumentException if the title is blank.
   */
  public void setTitle(String title) {
    if (Objects.equals(title, "")) {
      throw new IllegalArgumentException("Title can not be blank");
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
   * @throws IllegalArgumentException if the content is empty.
   */
  public void setContent(String content) {
    if (content.isEmpty()) {
      throw new IllegalArgumentException("Content can not be empty");
    }
    this.content = content;
    this.lastModifiedAt = LocalDateTime.now();
  }

  /**
   * Returns a formatted string representation of the diary entry,
   * including ID, author name, timestamps, title, and content.
   *
   * @return a string describing this diary entry
   */
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
