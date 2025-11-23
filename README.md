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
**edu.ntnu.idi.idatt**
#### JUnit Test Classes:
The test classes are stored under:
**src/test/java/edu/ntnu/idi/idatt/**

Thepackage includes:
|**Entity classes:**| Author and DiaryEntry|
|**Register classes:**| AuthorRegister and DieryEntryRegister|
|**UI and application classes:**| DiaryUi and DiaryApplication|
|**Utility classes**| StdoutConsoulHandler and cleanFormatter|

This keeps the domain logic and user interface readable and well-organized, and tool components are also kept neatly grouped.
[//]: # (TODO: Describe the structure of your project here. How have you used packages in your structure. Where are all sourcefiles stored. Where are all JUnit-test classes stored. etc.)

## Link to repository

https://github.com/NTNU-IDI/mappe-2025-CathKri

[//]: # (TODO: Include a link to your GitHub repository here.)

## How to run the project

#### Open the Project:

#### Ensure is Configured:

#### Build the Project:

#### Run the Application:

#### Input and Output:

#### Expected Behavior:

[//]: # (TODO: Describe how to run your project here. What is the main class? What is the main method?
What is the input and output of the program? What is the expected behaviour of the program?)

## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)

## References

References are included in the project report.

[//]: # (TODO: Include references here, if any. For example, if you have used code from the course book, include a reference to the chapter.
Or if you have used code from a website or other source, include a link to the source.)

"""
















