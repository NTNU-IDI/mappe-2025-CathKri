package edu.ntnu.idi.idatt;

import java.time.LocalDate;

/**
 *
 */
public class DiaryEntryUI {

    public void init() {
        System.out.println("Diary app ready.");
    }

    /**
     *
     */
    public void start() {
        DiaryEntry morningplanEntry = new DiaryEntry(1, "Morning thoughts", "A long to-do list.");
        morningplanEntry.setTitle("Morning thoughts: ");
        morningplanEntry.setContent("A long to-do list.");

        DiaryEntry studysessionEntry = new DiaryEntry(2, "Study session", "Finished all the required math tasks.");
        studysessionEntry.setTitle("Study session: ");
        studysessionEntry.setContent("Finished all the required math tasks.");

        DiaryEntry overwievEntry = new DiaryEntry(3, "Overwiev of the day", "Today i worked on my mathprogression and wrote a note for my english task.");
        studysessionEntry.setTitle("Overwiev of the day: ");
        studysessionEntry.setContent("Today i worked on my mathprogression and wrote a note for my english task.");


        printEntry(morningplanEntry);
        printEntry(studysessionEntry);
        printEntry(overwievEntry);
    }

    /**
     * prints the details for the entry
     * @param entry
     */
    private void printEntry(DiaryEntry entry) {
        System.out.println("Welcome to your digital diary!");
        System.out.println("id: " + entry.getId());
        System.out.println("date: " + entry.getDate());
        System.out.println("title: " + entry.getTitle());
        System.out.println("content: " + entry.getContent());
        System.out.println(entry);
    }


}