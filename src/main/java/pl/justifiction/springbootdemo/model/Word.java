package pl.justifiction.springbootdemo.model;

import java.util.*;

public class Word {

    String word;

    public Word(String word) {
        this.word = word;

    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "Word: " + word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }


}
