package pl.justifiction.springbootdemo.model;

import java.util.*;

public class Words {
    private HashMap<Word, Integer> collecitonsofwords;

    public Words() {
        collecitonsofwords = new HashMap<>();
    }

    public boolean addWord(String word) {
        Word word2 = new Word(word);
        int prev = 0;

        if (collecitonsofwords.get(word2) != null) {
            prev = collecitonsofwords.get(word2);
        }

        collecitonsofwords.put(word2, prev + 1);
        return true;
    }

    public boolean removeWord(String word) {
        int freq;
        Word word2 = new Word(word);
        if (collecitonsofwords.get(word2) != null) {
            freq = collecitonsofwords.get(word2);
            if (freq != 1)
                collecitonsofwords.put(word2, freq - 1);
            else
                collecitonsofwords.remove(word2);

            return true;
        }

        return false;
    }

    public boolean removeAllWords() {
        if (!collecitonsofwords.isEmpty()) {
            collecitonsofwords.clear();

            return true;
        }

        return false;
    }

    public int checkFrequency(String word) {
        Word word2 = new Word(word);
        int prev = -1;
        if (collecitonsofwords.get(word2) != null) {
            prev = collecitonsofwords.get(word2);
        }
        return prev;
    }


    public Set<Word> getUniqueWords() {
        Set<Word> keys = new HashSet<Word>();


        for (Map.Entry<Word, Integer> entry : collecitonsofwords.entrySet()) {
            if (Objects.equals(1, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        if (keys.isEmpty())
            return null;
        else
            return keys;

    }

    public HashMap<Word, Integer> allWords() {
        if (!collecitonsofwords.isEmpty()) {
            return collecitonsofwords;
        } else
            return null;

    }
}
