package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DiaryEntryTest {

    @Test
    void constructorStoresAllValue() {
        int id = 1;
        LocalDate date = LocalDate.of(2025, 10, 12);
        String title = "Day one";
        String content = "To do list";


        DiaryEntry entry = new DiaryEntry(id, title, content);

        assertEquals(id, entry.getId());
        assertEquals(date, entry.getDate());
        assertEquals(title, entry.getTitle());
        assertEquals(content, entry.getContent());

    }
    @Test
    void settersUpdateText() {
        DiaryEntry entry = new DiaryEntry(
                1,
                "Old title",
                "Old text"
        );

        entry.setTitle("New title");
        entry.setContent("New text");

        assertEquals("New title", entry.getTitle());
        assertEquals("New text", entry.getContent());
    }
    @Test
    void constructorRejectsNullId(){
        assertThrows(IllegalArgumentException.class, () ->
                new DiaryEntry(null, "Title", "Content"));
    }

    @Test
    void constructorRejectsBlankTitle(){
        int id =1;

        assertThrows(IllegalArgumentException.class, () ->
                new DiaryEntry(id, "  ", "Content"));

    }
    @Test
    void setterRejectsBlankContent(){
        DiaryEntry entry = new DiaryEntry(
                1,
                "Some title",
                "Some content"
        );
        assertThrows(IllegalArgumentException.class, () -> entry.setContent(""));
    }

}