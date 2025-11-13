package edu.ntnu.idi.idatt;

public class DiaryApplication {
    public static <DiaryUI> void main(String[] args) {
        DiaryUI ui = new DiaryUI();

        ui.init();
        ui.start();
    }



}
