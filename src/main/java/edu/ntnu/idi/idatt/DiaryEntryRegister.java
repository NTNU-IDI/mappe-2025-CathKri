package edu.ntnu.idi.idatt;

import java.time.LocalDate;
import java.util.ArrayList;

public class DiaryEntryRegister {
    private ArrayList<DiaryEntry> DiaryEntries;

    public DiaryEntryRegister() {
        DiaryEntries = new ArrayList();
    }

    public void addDiaryEntry(DiaryEntry diaryEntry) {
        DiaryEntries.add(diaryEntry);
    }

    public DiaryEntry findRegisteredDiaryEntryByDate(LocalDate date) {
        for (DiaryEntry diaryEntry : DiaryEntries) {
            if (diaryEntry.getDate().equals(date)) {
                return diaryEntry;
            }
        }
        return null;
    }

    public void deleteDiaryEntry(DiaryEntry diaryEntry) {
        DiaryEntries.remove(diaryEntry);
    }

    public void findRegisteredDiaryEntries() {
        ArrayList<DiaryEntry> DiaryEntries =  this.DiaryEntries;
        for (DiaryEntry DiaryEntry : DiaryEntries)  {
            System.out.println(DiaryEntry.toString());
        }
    }

}

