package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DiaryEntryTest {

    @Test
    void constructorStoresAllValue() {
        String authorsName = "Shara";
        LocalDate date = LocalDate.of(2025, 10, 12);
        LocalTime time = LocalTime.parse("15:00");
        String title = "Day one";
        String content = "To do list";


        DiaryEntry entry = new DiaryEntry(authorsName, date, time, title, content);

        assertEquals(authorsName, entry.getAuthorsName());
        assertEquals(date, entry.getDate());
        assertEquals(time, entry.getTime());
        assertEquals(title, entry.getTitle());
        assertEquals(content, entry.getContent());

    }
    @Test
    void settersUpdateText() {
        DiaryEntry entry = new DiaryEntry("Shara", LocalDate.parse("2025-11-12"), LocalTime.parse("07:30"), "Plan for det day", "A long to-do list.");

        entry.setTitle("New title");
        entry.setContent("New text");

        assertEquals("New title", entry.getTitle());
        assertEquals("New text", entry.getContent());
    }
    @Test
    void constructorRejectsNullId(){
        assertThrows(IllegalArgumentException.class, () ->
                new DiaryEntry("Shara", LocalDate.parse("2025-11-12"), LocalTime.parse("07:30"), "Plan for det day", "A long to-do list."));
    }

    @Test
    void constructorRejectsBlankTitle(){
        int id =1;

        assertThrows(IllegalArgumentException.class, () ->
                new DiaryEntry("Shara", LocalDate.parse("2025-11-12"), LocalTime.parse("07:30"), "Plan for det day", "A long to-do list."));

    }
    @Test
    void setterRejectsBlankContent(){
        DiaryEntry entry = new DiaryEntry("Shara", LocalDate.parse("2025-11-12"), LocalTime.parse("07:30"), "Plan for det day", "A long to-do list.");
        assertThrows(IllegalArgumentException.class, () -> entry.setContent(""));
    }

}