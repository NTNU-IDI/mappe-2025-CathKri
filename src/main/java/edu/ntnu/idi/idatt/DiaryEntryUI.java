package edu.ntnu.idi.idatt;

import java.time.LocalDate;

public class DiaryEntryUI {

    public void init() {
        System.out.println("Diary app ready.");
    }

    public void start() {
        DiaryEntry morningEntry = new DiaryEntry(
                1,
                "Morning thoughts",
                "Waffles with strawberries and a long to-do list."
        );
        DiaryEntry studyEntry = new DiaryEntry(
                2,
                "Study session",
                "Finished all the required math tasks."
        );
        DiaryEntry eksamEntry = new DiaryEntry(
                3,
                "Eksam planning",
                "prepare for the final eksam by planing a weekly to do list for repetition."
        );
        printEntry(morningEntry);
        printEntry(studyEntry);
        printEntry(eksamEntry);
    }

    private void  printEntry(DiaryEntry entry) {
        System.out.println("Diary app started.");
        System.out.println("id: " + entry.getId());
        System.out.println("date: " + entry.getDate());
        System.out.println("title: " + entry.getTitle());
        System.out.println("content: " + entry.getContent());
        System.out.println(entry);
    }
}