package edu.ntnu.idi.idatt;

public final class Main {

    private Main() {
    }

    public static void Main (String[]args){
            DiaryEntryUI ui = new DiaryEntryUI();
            ui.init();
            ui.start();
    }
}