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
 * Provides a console-based user interface for interacting with the diary application.
 * This class handles all user interaction, including:
 * <ul>
 *   <li>Registering new diary entries</li>
 *   <li>Searching for entries based on date or keywords</li>
 *   <li>Listing all diary entries</li>
 *   <li>Deleting entries</li>
 *   <li>Displaying the number of posts per author</li>
 * </ul>
 * The class communicates with {@link DiaryEntryRegister} and {@link AuthorRegister}
 * to perform operations, while logging output using {@link java.util.logging.Logger}.
 * <p>
 * Note: This class mixes input handling, validation and control flow,
 * and therefore acts as both UI and controller in this version of the system.</p>
 */
@SuppressWarnings("checkstyle:LineLength")
public class DiaryUi {

  Logger logger = Logger.getLogger(getClass().getName());
  DiaryEntryRegister diaryEntryRegister;
  AuthorRegister authorRegister;

  /**
   * Creates and registers a new diary entry.
   * Prompts the user for ID, title, content and author information.
   *
   * @param register       the diary entry register used to store the entry
   * @param AuthorRegister the author register used for finding or creating authors
   * @param scanner        the scanner used to read user input
   */
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

  /**
   * Displays all registered diary entries in the system.
   *
   * @param register the diary register to retrieve entries from
   */
  private void findRegisteredDiaryEntry(DiaryEntryRegister register) {
    logger.info("Find all recorded diary entries: ");
    printResults(register.getAllDiaryEntries());
  }

  /**
   * Finds an existing author or creates a new one if not found.
   * Prompts the user for first name, last name, and optionally email.
   *
   * @param authorRegister the register containing authors
   * @return the found or newly created author
   */
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


  /**
   * Searches for diary entries within a given date range.
   * Prompts the user for from/to dates in yyyyMMdd format.
   *
   * @param register the diary entry register
   * @param scanner  the scanner used for input
   *
   * <p><b> NOTE: </b> Parts of the implementation of
   * {@code findRegisteredDiaryEntryBetweendates} was developed with assistance from ChatGPT.
   *  The logic was reviewed and integrated into the project by the author.</p>
   */
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
   * Searches for diary entries that contain a given keyword in either title or content.
   *
   * @param register the diary entry register
   * @param scanner  scanner used to read search term
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
   * Displays the number of diary posts created by each author.
   *
   * @param diaryEntryRegister the diary register
   * @param authorRegister     the author register
   */
  public void numberOfPostPerAuthor(DiaryEntryRegister diaryEntryRegister, AuthorRegister authorRegister) {
    logger.info("Number of posts per author: ");
    List<AuthorPostCount> authorPostCounts = authorRegister.createAuthorPostList(diaryEntryRegister, authorRegister);
    authorRegister.printAuthorPostList(authorPostCounts);
  }

  /**
   * Deletes a diary entry based on its ID.
   *
   * @param register the register containing entries
   * @param scanner  scanner used to read ID
   */
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

  /**
   * Prints a list of diary entries in descending order by creation date.
   *
   * @param results the list of diary entries
   */
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
   * Initializes the diary application by creating registers and preparing logging.
   */
  public void init() {
    diaryEntryRegister = new DiaryEntryRegister();
    authorRegister = new AuthorRegister();
    logger.info("The diary-app is ready ");
  }

  /**
   * Starts the UI loop and displays a menu until the user exits.
   * Also loads example data at startup.
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

  /**
   * Prints the main menu options for the user.
   */
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
   * Prints the detailed information of a single diary entry.
   *
   * @param entry the diary entry to print
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