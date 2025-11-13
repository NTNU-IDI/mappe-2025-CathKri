package edu.ntnu.idi.idatt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

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
        DiaryEntry morningplanEntry = new DiaryEntry("Shara", LocalDate.parse("2025-11-12"), LocalTime.parse("07:30"), "Plan for det day", "A long to-do list.");
        DiaryEntry studysessionEntry = new DiaryEntry("Shara", LocalDate.parse("2025-11-12"), LocalTime.parse("15:00"), "Study session", "Finished all the required math tasks.");
        DiaryEntry overwievEntry = new DiaryEntry("Alex", LocalDate.parse("2025-11-12"), LocalTime.parse("20:00"), "Overwiev of the day", "Today i worked on my mathprogression and wrote a note for my english task.");


        printEntry(morningplanEntry);
        printEntry(studysessionEntry);
        printEntry(overwievEntry);

        DiaryEntryRegister register = new DiaryEntryRegister();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 0) ;
        printEntry();
        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addDiaryEntry(register, sc);
                break;
            case 2:
                findRegisteredDiaryEntries();
                break;
            case 3:
                findRegisteredDiaryEntryByDate(register, sc);
                break;
            case 4:
                deleteDiaryEntry();
                break;
            case 5:
                findRegisteredDiaryEntryByDate(register, sc);
                break;
            case 6:
                System.out.println("Thank you for using our diary entry register.");
                break;
            default:
                System.out.println("Invalid choice. Try again.");


        }
    }

    /**
     * prints the details for the entry
     *
     * @param entry
     */
    private void printEntry(DiaryEntry entry) {
        System.out.println("Welcome to your digital diary!");
        System.out.println("Authors name: " + entry.getAuthorsName());
        System.out.println("date: " + entry.getDate());
        System.out.println("time: " + entry.getTime());
        System.out.println("title: " + entry.getTitle());
        System.out.println("content: " + entry.getContent());
        System.out.println(entry);
    }

    private static void addDiaryEntry(DiaryEntryRegister register, Scanner sc) {
        System.out.println("Register new diary entry!: ");
        System.out.println("Authors name: ");
        String authorsName = sc.nextLine();


        System.out.println("What is todays date: ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("What is the time of your entry: ");
        LocalTime time = LocalTime.parse(sc.nextLine());
        sc.nextLine();

        System.out.println("Enter a title: ");
        String title = sc.nextLine();

        System.out.println("Enter the content: ");
        String content = sc.nextLine();


        DiaryEntry Diary = new DiaryEntry(authorsName, date, time, title, content);
        register.addDiaryEntry(Diary);
        System.out.println("Eiendom ble registrert!");
    }

    private static void findRegisteredDiaryEntryByDate(DiaryEntryRegister register, Scanner sc) {
        System.out.println("Find diary entry by date");
        System.out.print("Enter date (format: YYYYMMDD, e.g., 20250615): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        DiaryEntry results = register.findRegisteredDiaryEntryByDate(date);
        printResultat(results);
    }

    private static void deleteDiaryEntry(DiaryEntry diaryEntry) {
        System.out.println("Delete diary entry.");

    }

    private static void findRegisteredDiaryEntries() {

    }

    private static void printResultat(DiaryEntry resultat) {
        if (resultat == null) {
            System.out.println("No Diary entry found.");
        } else {
            System.out.println(resultat.toString());
        }
    }

    }




}