package edu.ntnu.idi.idatt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaryEntryRegister {
  private final ArrayList<DiaryEntry> AlleDagbokinnlegg;

  public DiaryEntryRegister() {
    AlleDagbokinnlegg = new ArrayList();
  }

  public void addDiaryEntry(DiaryEntry dagbokinnlegg) {
    AlleDagbokinnlegg.add(dagbokinnlegg);
  }

  public ArrayList<DiaryEntry> getAllDiaryEntries() {
    return AlleDagbokinnlegg;
  }

  public void finnAlleRegistrerteDagbokinnlegg() {
    ArrayList<DiaryEntry> AlleDagbokinnlegg = this.AlleDagbokinnlegg;
    for (DiaryEntry Dagbokinnlegg : AlleDagbokinnlegg) {
      System.out.println(Dagbokinnlegg.toString());
    }
  }

  public List<DiaryEntry> finnRegistrertDagbokinnleggEtterDato(LocalDateTime fraDato, LocalDateTime tilDato) {
    List<DiaryEntry> resultatListe = new ArrayList<>();

    for (DiaryEntry dagbokinnlegg : AlleDagbokinnlegg) {
      LocalDateTime opprettet = dagbokinnlegg.getCreatedAt();

      if ((opprettet.isEqual(fraDato) || opprettet.isAfter(fraDato)) &&
          (opprettet.isEqual(tilDato) || opprettet.isBefore(tilDato))) {

        resultatListe.add(dagbokinnlegg);
      }
    }
    return resultatListe;
  }

  public ArrayList<DiaryEntry> finnAlleDagbokinnleggBasertPåOrd(String ord) {
    ArrayList<DiaryEntry> resultatListe = new ArrayList<>();

    if (ord == null || ord.isBlank()) {
      return resultatListe;
    }

    String søkeord = ord.toLowerCase();

    for (DiaryEntry dagbokinnlegg : AlleDagbokinnlegg) {
      String tittel = dagbokinnlegg.getTitle();
      String innhold = dagbokinnlegg.getContent();

      if ((tittel != null && tittel.toLowerCase().contains(søkeord)) ||
          (innhold != null && innhold.toLowerCase().contains(søkeord))) {

        resultatListe.add(dagbokinnlegg);
      }
    }

    return resultatListe;

  }

  public void DeleteDiaryEntry(DiaryEntryRegister register, int id) {
    DiaryEntry dagbokinnleggToRemove = null;
    for (DiaryEntry dagbokinnlegg : AlleDagbokinnlegg) {
      if (dagbokinnlegg.getId() == id) {
        dagbokinnleggToRemove = dagbokinnlegg;
        System.out.println("Dagbokinnlegg " + id + " har blitt slettet");
      }
    }
    if (dagbokinnleggToRemove != null) {
      register.AlleDagbokinnlegg.remove(dagbokinnleggToRemove);
    } else {
      System.out.println("Dagbokinnlegg with id: " + id + " not found.");
    }
  }


}

