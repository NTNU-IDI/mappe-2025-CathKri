package edu.ntnu.idi.idatt;

public class DiaryApplication {
  public static void main(String[] args) {
    System.setProperty("java.util.logging.config.file",
        DiaryApplication.class.getClassLoader()
            .getResource("logging.properties").getFile());

    DiaryUi DiaryUI = new DiaryUi();
    DiaryUI.init();
    DiaryUI.start();
  }


}
