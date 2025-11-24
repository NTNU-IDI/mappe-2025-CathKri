package edu.ntnu.idi.idatt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Diary entry UI class.
 */
@SuppressWarnings("checkstyle:LineLength")
public class DiaryUi {

  Logger logger = Logger.getLogger(getClass().getName());
  DiaryEntryRegister diaryEntryRegister;
  AuthorRegister authorRegister;

  private void addDiaryEntry(DiaryEntryRegister register, AuthorRegister AuthorRegister, Scanner scanner) {
    logger.info("Register new diary entry: ");
    logger.info("Id number: ");
    final int id;
    try {
      id = scanner.nextInt();
      scanner.nextLine();
    } catch (InputMismatchException exception) {
      scanner.nextLine();
      logger.info("Invalid input: " + exception.getMessage());
      return;
    }

    final Author author = findOrCreateAuthor(AuthorRegister);

    logger.info("Title:");
    String title = scanner.nextLine();

    logger.info("Content:");
    String content = scanner.nextLine();

    LocalDateTime date = LocalDateTime.now();
    logger.info("Created at: " + date);

    DiaryEntry Diary = new DiaryEntry(id, author, date, title, content);
    register.addDiaryEntry(Diary);
    logger.info("Diary entry added!");
  }

  private void findRegisteredDiaryEntry(DiaryEntryRegister register) {
    logger.info("Find all recorded diary entries: ");
    printResults(register.getAllDiaryEntries());
  }

  private Author findOrCreateAuthor(AuthorRegister authorRegister) {
    logger.info("Find author from the list or create new author: ");

    Scanner scanner = new Scanner(System.in);

    logger.info("Author's firstname: ");
    String firstName;
    firstName = scanner.next();
    logger.info("Author's lastname: ");
    String lastName;
    lastName = scanner.next();
    if (authorRegister.findAuthor(firstName, lastName) != null) {
      logger.info("Author found!");
      return authorRegister.findAuthor(firstName, lastName);
    } else {
      logger.info("Author not found. Please provide email to create a new author.");
      logger.info("Author's email: ");
      String email;
      email = scanner.next();
      Author author = new Author(firstName, lastName, email);
      authorRegister.addAuthor(author);
      return author;
    }
  }

  private void findRegisteredDiaryEntryBetweendates(DiaryEntryRegister register, Scanner scanner) {
    logger.info("Find diary entries by date:\n");

    logger.info("Write from date: (format: yyyyMMdd, e.g., 20250615): ");
    String fromInput = scanner.nextLine();

    logger.info("Write to date: (format: yyyyMMdd, e.g., 20250615): ");
    String toInput = scanner.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    LocalDateTime fromDate;
    LocalDateTime toDate;
    try {
      fromDate = LocalDate.parse(fromInput, formatter).atStartOfDay();
      toDate = LocalDate.parse(toInput, formatter).atTime(23, 59, 59);
    } catch (DateTimeParseException exception) {
      logger.warning("Invalid date: " + exception.getMessage());
      return;
    }


    List<DiaryEntry> results = register.findRegisteredDiaryEntriesBasedOnDate(fromDate, toDate);

    printResults(results);
  }

  /**
   * Find all diary entries.
   *
   * @param register diary registry
   * @param scanner  scanner
   */
  public void findAllDiaryEntriesBasedOnWord(DiaryEntryRegister register, Scanner scanner) {
    logger.info("Enter a word to search for: ");
    String word = scanner.nextLine();

    String searchTerm = word.toLowerCase();
    int searchResult = 0;

    for (DiaryEntry DiaryEntry : register.getAllDiaryEntries()) {
      String title = DiaryEntry.getTitle();
      String content = DiaryEntry.getContent();

      if ((title != null && title.toLowerCase().contains(searchTerm)) || (content != null && content.toLowerCase().contains(searchTerm))) {
        String diaryEntry = DiaryEntry.toString();
        logger.info(diaryEntry);
        searchResult++;
      }
    }

    if (searchResult == 0) {
      logger.warning("No diaries have been found with the word: " + word);
    }
  }

  /**
   * Number of diaries per author.
   *
   * @param diaryEntryRegister       diaryEntryRegister
   * @param authorRegister authorRegister
   */
  public void numberOfPostPerAuthor(DiaryEntryRegister diaryEntryRegister, AuthorRegister authorRegister) {
    logger.info("Number of posts per author: ");
    List<AuthorPostCount> authorPostCounts = authorRegister.createAuthorPostList(diaryEntryRegister, authorRegister);
    authorRegister.printAuthorPostList(authorPostCounts);
  }

  private void DeleteDiaryEntry(DiaryEntryRegister register, Scanner scanner) {
    logger.info("Delete diary Entry: ");
    logger.info("Id number: ");
    int id;
    try {
      id = scanner.nextInt();
      scanner.nextLine();
    } catch (InputMismatchException exception) {
      scanner.nextLine();
      logger.info("Invalid input: " + exception.getMessage());
      return;
    }

    register.DeleteDiaryEntry(register, id);
  }

  private void printResults(List<DiaryEntry> results) {
    if (results == null || results.isEmpty()) {
      logger.info("No diary entries found!");
      return;
    }
    results.sort(Comparator.comparing(DiaryEntry::getCreatedAt).reversed());

    String found = "Found " + results.size() + " diary entry(s):";
    logger.info(found);
    for (DiaryEntry diaryEntry : results) {
      String diaryEntryString = diaryEntry.toString();
      logger.info(diaryEntryString);
    }
  }

  /**
   * init.
   */
  public void init() {
    diaryEntryRegister = new DiaryEntryRegister();
    authorRegister = new AuthorRegister();
    logger.info("The diary-app is ready ");
  }

  /**
   * start.
   */
  public void start() {
    Author shara = new Author("Shara", "Johansen", "sara@hotmail.com");
    Author mikael = new Author("Mikael", "Evensen", "evensen@hotmail.com");
    Author tore = new Author("Tore", "Olavsen", "TorOlav@hotmail.com");

    DiaryEntry morningEntry = new DiaryEntry(1, shara, LocalDateTime.now(), "Plan of the day", "To-do list:");
    DiaryEntry studySession = new DiaryEntry(2, mikael, LocalDateTime.now(), "Today's study session", "Completed all required math assignments");
    DiaryEntry reflectionOfTheDay = new DiaryEntry(3, tore, LocalDateTime.now(), "Overview of the day", "Today I worked on math assignments and wrote a note for the English assignment.");

    printDiaryEntry(morningEntry);
    printDiaryEntry(studySession);
    printDiaryEntry(reflectionOfTheDay);

    authorRegister.addAuthor(shara);
    authorRegister.addAuthor(mikael);
    authorRegister.addAuthor(tore);

    diaryEntryRegister.addDiaryEntry(morningEntry);
    diaryEntryRegister.addDiaryEntry(studySession);
    diaryEntryRegister.addDiaryEntry(reflectionOfTheDay);

    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    while (choice != 7) {
      printMenu();
      try {
        choice = scanner.nextInt();
        scanner.nextLine();
      } catch (Exception exception) {
        scanner.nextLine();
        logger.info("Invalid input: " + exception.getMessage());
      }

      switch (choice) {
        case 1:
          addDiaryEntry(diaryEntryRegister, authorRegister, scanner);
          break;
        case 2:
          findRegisteredDiaryEntry(diaryEntryRegister);
          break;
        case 3:
          findRegisteredDiaryEntryBetweendates(diaryEntryRegister, scanner);
          break;
        case 4:
          DeleteDiaryEntry(diaryEntryRegister, scanner);
          break;
        case 5:
          findAllDiaryEntriesBasedOnWord(diaryEntryRegister, scanner);
          break;
        case 6:
          numberOfPostPerAuthor(diaryEntryRegister, authorRegister);
          break;
        case 7:
          logger.info("Thank you for using our diary entry diaryEntryRegister.");
          break;
        default:
          logger.info("Invalid choice. Try again.");
      }
    }

  }

  private void printMenu() {
    logger.info("\n DIARY ENTRY MENU");
    logger.info("1. Add new diary entry");
    logger.info("2. Show all registered diary entries");
    logger.info("3. Find diary entries between two dates");
    logger.info("4. Delete a diary entry");
    logger.info("5. Search for diary entries based on words");
    logger.info("6. Show number of entries per author");
    logger.info("7. Exit the program");
    logger.info("Select an option (1–7): ");
  }

  /**
   * prints the details for the entry.
   *
   * @param entry entry
   */
  private void printDiaryEntry(DiaryEntry entry) {
    logger.info("Id: " + entry.getId());
    logger.info("date: " + entry.getCreatedAt());
    logger.info("title: " + entry.getTitle());
    logger.info("content: " + entry.getContent());
    String entryString = entry.toString();
    logger.info(entryString);
  }
}