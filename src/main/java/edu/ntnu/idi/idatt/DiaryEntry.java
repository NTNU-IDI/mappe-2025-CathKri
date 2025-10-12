package edu.ntnu.idi.idatt;

import java.time.LocalDate;

/**
 * This class represents a diary entry.
 * It holds the information from a client day by day.
 * It asks for the id, date, title and content.
 *
 */
public class DiaryEntry {

    private final Integer Id;
    private final LocalDate date;
    private String title;
    private String content;

    /**
     * This is the constructor for diary entry.
     * It takes the parameters id, title and content.
     * It also sets the date to today's date.
     *
     * @param id      id of the entry (can not be blank)
     * @param title   title of the entry (can not be blank)
     * @param content content of the entry (can not be blank)
     */
    public DiaryEntry(Integer id, String title, String content) {
        if (id == null) {
            throw new IllegalArgumentException("id is missing");
        }
        if (title == null) {
            throw new IllegalArgumentException("title is missing");
        }
        if (content == null) {
            throw new IllegalArgumentException("content is missing");
        }
        this.Id = id;
        this.date = LocalDate.now();
        this.title = title;
        this.content = content;
    }

    /**
     * Takes the id of the entry.
     */
    public int getId() {
        return Id;
    }

    /**
     * Takes the today's date of the entry.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Takes the title of the entry.
     */
    public String getTitle() {
        return title;
    }
    /**
     *
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        this.title = title;
    }

    /**
     * Takes the content of the entry.
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("content is null");
        }
        this.content = content;
    }
}
