package edu.ntnu.idi.idatt;

import java.util.ArrayList;

/**
 *
 */
public class AuthorRegister {
    private ArrayList<Author> Authors;

    public AuthorRegister() {
        Authors = new ArrayList<Author>();
    }

    public ArrayList<Author> getAuthors() {return Authors;}

    public void setAuthors(ArrayList<Author> authors) {Authors = authors;}

    public void addAuthor(Author author) {Authors.add(author);}

    public void findDiaryEntriesFromSpesificAuthor(){

    }
    public void findDiaryEntriesBasedOnAWord(){
    }
    public void findDiaryEntriesBasedOnAuthor(){

    }
    public int numberOfPostPrAuthor(){
        return Authors.size();
    }

    
}
