# mappe-2025-CathKri


# Portfolio project IDATT1003
 <!This file uses Mark Down syntax. For more information see [here](https://www.markdownguide.org/basic-syntax/).>

[//]: # (TODO: Fill inn your name and student ID)

STUDENT NAME = Cathrine Kristiansen  
STUDENT ID = 128744

## Project description
This project is a diary application developed as part of the portfolio assignment in **IDATT1003 – Programming 1** at NTNU.
The application allows users to create, view, search, and delete diary entries. It supports multiple authors, search ranged by the latest post, searching based on keywords, and generating statistics showing the number of diary entries per author. 

### The solution includes:

- A text-based user interface

- Core entity classes (DiaryEntry, Author)

- Registers for storing entries and authors

- Exception handling and validation

- Sorting and filtering functionality

- Logging using Java’s built-in logging framework

This project satisfies the functional requirements for both **Level 1** and **Level 2** described in the assignment.

## Project structure

#### Source Files:
|Files:|Description:|
|------|------------|
|Author.java|Entety class that represent an author (firstname, lastname, email).|
|DiaryEntry.java|Entety class that represent a diary entry with id, author, timestamp, title and content.|
|AuthorRegister.java|Stores authors and generates statistics such as number of posts per author.|
|DiaryEntryRegister.java|Stores and manages all diary entries. Supports searching, filtering, and deleting.|
|DiaryUi.java|Text-based user interface and menu handling.|
|DiaryApplication.java|Main application launcher.|
|StdoutConsoulHandler.java, CleanFormatter.java|Custom logging output handlers and formatter.|
#### Packages:
All source files are located in:
[edu.ntnu.idi.idatt](src/main/java/edu/ntnu/idi/idatt/)
#### JUnit Test Classes:
The test classes are stored under:
[src/test/java/edu/ntnu/idi/idatt/](src/test/java/edu/ntnu/idi/idatt/)


**The package includes:**
|Packages|classes|
|--------|-------|
|**Entity classes:**| Author and DiaryEntry|
|**Register classes:**| AuthorRegister and DieryEntryRegister|
|**UI and application classes:**| DiaryUi and DiaryApplication|
|**Utility classes**| StdoutConsoulHandler and cleanFormatter|

This keeps the domain logic and user interface readable and well-organized, and tool components are also kept neatly grouped.

## Link to repository
Github repository:

https://github.com/NTNU-IDI/mappe-2025-CathKri

[//]: # (TODO: Include a link to your GitHub repository here.)

## How to run the project

#### Open the Project:
-	Clone the repository using Git:
-	git clone https://github.com/NTNU-IDI/mappe-2025-CathKri
-	Open the folder in **IntelliJ IDEA**, **VS Code**, or another Java IDE(i have used IntelliJ IDEA).

#### Ensure is Configured:
The project uses Maven.

Verify that:
-	JDK 21 is selected
-	Maven imports dependencies automatically

#### Build the Project:
From the terminal:
mvn clean compile
Or using IDE build tools.

#### Run the Application:
Run the main class:

[edu.ntnu.idi.idatt.DiaryApplication](src/main/java/edu/ntnu/idi/idatt/DiaryApplication.java)

Or via terminal:

mvn exec:java -Dexec.mainClass="[edu.ntnu.idi.idatt.DiaryApplication](src/main/java/edu/ntnu/idi/idatt/DiaryApplication.java)"

#### Input and Output:
- The program starts with three example diary entries and authors.
-	A menu will appear where the user can:
1.	Add a new diary entry
2.	Show all diary entries
3.	Search entries between two dates
4.	Delete an entry
5.	Search entries based on a keyword
6.	View number of entries per author
7.	Exit

#### Expected Behavior:
The main class of the application is:

[edu.ntnu.idi.idatt.DiaryApplication](src/main/java/edu/ntnu/idi/idatt/DiaryApplication.java)

This class contains the public static void main(String[] args) method, which starts the program. Inside the main method, an instance of DiaryUi is created, and the methods init() and start() are executed to initialize the application and launch the text-based user interface.

### Input and Output

**Input:**
The program receives user input through the console using a numbered menu system.
Users can enter:
- Integer values (e.g., diary entry ID, menu choices)
- Strings for titles, content, and author information
- Dates in the format yyyyMMdd

**Output:**
All output is printed to the console using Java’s logging system.
Output includes:
- Confirmation messages
- Lists of diary entries
- Search results
- Warning messages when invalid input is provided

 ### Expected Behavior of the Program

When the program runs, the user is presented with a menu containing seven options. The expected behaviour for each option is:

**1. Add a new diary entry**
The user provides an ID, author information, a title, and content.
A new DiaryEntry is created with a timestamp and stored in the register.

**2. Show all registered diary entries**
The program prints all entries sorted in descending order based on creation time.

**3. Find diary entries between two dates**
The user enters a start date and an end date (format: yyyyMMdd).
All entries that fall within this interval are displayed.

**4. Delete a diary entry**
The user enters an ID, and the corresponding entry is removed if it exists.

**5. Search for diary entries based on a word**
The program searches both the title and content for the given keyword and prints matching entries.

**6. Show number of entries per author**
A list is displayed showing each author and how many entries they have written.

**7. Exit the program**
The application ends.

## How to run the tests
The project uses JUnit 5 for unit testing, and all tests are executed through Maven.
All test classes are located in the standard Maven test directory:

[src/test/java/edu/ntnu/idi/idatt/](src/test/java/edu/ntnu/idi/idatt/)

To run the entire test suite, use one of the following methods:

**1. Running Tests from the Terminal**
Run all tests using Maven:
mvn test
Maven will automatically compile the test classes and execute all JUnit tests in the project.

**2. Running Tests in IntelliJ IDEA (or another IDE)**
Open the project in your IDE
Navigate to the src/test/java folder
Right-click either:
the test package,
an individual test class, or
a single test method
Choose Run ‘Tests’

This allows you to run all tests or only a subset.
The tests covers both positive and negative test scenarios. 

## References

References are included in the project report.

[//]: # (TODO: Include references here, if any. For example, if you have used code from the course book, include a reference to the chapter.
Or if you have used code from a website or other source, include a link to the source.)


























