package pl.justifiction.springbootdemo.model;

import org.springframework.stereotype.Service;

@Service
public class DataGenerator {
    public Words words = new Words();

    public DataGenerator() {

        words.addWord("dog");
        words.addWord("flower");
        words.addWord(("dog"));
        words.addWord("cat");
        words.addWord("dog");
        words.addWord("dog");
        words.addWord("cat");
        words.addWord("frog");
        words.addWord("frog");
        words.addWord("daisy");
        words.addWord("morning");
        words.addWord("sun");
        words.addWord("moon");


    }
}
