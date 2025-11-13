package edu.ntnu.idi.idatt;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class represents a diary entry.
 * It holds the information from a client day by day.
 * It asks for the id, date, title and content.
 *
 * @author Cathrine Kristiansen
 * @version 1.0
 * @since 2025-10-12
 */
public class DiaryEntry {

    private final String authorsName;
    private final LocalDate date;
    private final LocalTime time;
    private String title;
    private String content;


    /**
     * This is the constructor for diary entry.
     * It takes the parameters id, title and content.
     * It also sets the date to today's date.
     *
     * @param authorsName      id of the entry (can not be blank)
     * @param title   title of the entry (can not be blank)
     * @param content content of the entry (can not be blank)
     */
    public DiaryEntry(String authorsName, LocalDate date, LocalTime time, String title, String content) {
        if (authorsName == null) {
            throw new IllegalArgumentException("id is missing");
        }
        if (title == null) {
            throw new IllegalArgumentException("title is missing");
        }
        if (content == null) {
            throw new IllegalArgumentException("content is missing");
        }
        this.authorsName = authorsName;
        this.date = date;
        this.time = time;
        this.title = title;
        this.content = content;
    }



    /**
     * Takes the id of the entry.
     *
     * @return Id
     */
    public String getAuthorsName() {
        return authorsName;
    }

    /**
     * Takes the today's date of the entry.
     *
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @return time
     */
    public LocalTime getTime() {
        return time;
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
     * @param title
     * @throws IllegalArgumentException if the title shows blank
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        this.title = title;
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
     * @param content
     * @throws IllegalArgumentException if the content is blank.
     */
    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("content is null");
        }
        this.content = content;
    }
}
