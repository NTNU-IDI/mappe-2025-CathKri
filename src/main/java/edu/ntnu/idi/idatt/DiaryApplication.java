package edu.ntnu.idi.idatt;

import java.util.Objects;

/**
 * Entry point for the diary application.
 * This class configures the logging system and initializes the user interface
 * before starting the application workflow.
 */
public class DiaryApplication {

  /**
   * Main method used to launch the diary application.
   * The method performs the following steps:
   *   <li>Redirects error output to standard output for consistent logging.</li>
   *   <li>Configures the logging system using the {@code logging.properties} file.</li>
   *   <li>Creates an instance of {@link DiaryUi}.</li>
   *   <li>Initializes the application state by calling {@code init()}.</li>
   *   <li>Starts the user interface loop by calling {@code start()}.</li>
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    System.setErr(System.out);
    System.setProperty("java.util.logging.config.file",
        Objects.requireNonNull(DiaryApplication.class.getClassLoader()
            .getResource("logging.properties")).getFile());

    DiaryUi diaryUi = new DiaryUi();
    diaryUi.init();
    diaryUi.start();
  }
}
