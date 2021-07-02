package pl.justifiction.springbootdemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.justifiction.springbootdemo.controller.exception.CustomExeption;
import pl.justifiction.springbootdemo.model.DataGenerator;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired()
    private DataGenerator service;


    @Operation(summary = "Add a word")
    @PostMapping("/words")
    @ResponseBody
    public ResponseEntity<Object> saveWord(@RequestBody String word) {
        service.words.addWord(word);
        return new ResponseEntity<>("Word added correctly", HttpStatus.OK);


    }


    @Operation(summary = "Delete a word")
    @DeleteMapping("/words/{wordName}")
    @ResponseBody
    public ResponseEntity<Object> deleteWord(@PathVariable String wordName) throws CustomExeption {
        if (wordName == "")
            throw new CustomExeption("Wrong parameter provided", HttpStatus.BAD_REQUEST);
        else if (service.words.removeWord(wordName))
            return new ResponseEntity<>("Word deleted", HttpStatus.OK);
        else
            throw new CustomExeption("Not found the word", HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Delete every word from the collection")
    @DeleteMapping("/words")
    @ResponseBody
    public ResponseEntity<Object> deleteAllWords() throws CustomExeption {

        if (service.words.removeAllWords())
            return new ResponseEntity<>("Words deleted", HttpStatus.OK);
        else
            throw new CustomExeption("Nothing to delete", HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Get the collections of words")
    @GetMapping(" ")
    public ResponseEntity<Object> getAllWords() throws CustomExeption {
        if (service.words.allWords() != null)
            return new ResponseEntity<>(service.words.allWords(), HttpStatus.OK);
        else
            throw new CustomExeption("No words found", HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Get the number of word's occurences")
    @GetMapping("/words/{wordName}")
    public ResponseEntity<Object> getFreq(@PathVariable String wordName) throws CustomExeption {
        if (wordName == "")
            throw new CustomExeption("No input", HttpStatus.BAD_REQUEST);
        else if (service.words.checkFrequency(wordName) != -1)
            return new ResponseEntity<>(service.words.checkFrequency(wordName), HttpStatus.OK);
        else
            throw new CustomExeption("The word not found", HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Get the list of unique words")
    @GetMapping("/words")
    public ResponseEntity<Object> returnUniqueWords() {
        if (service.words.getUniqueWords() != null)
            return new ResponseEntity<>(service.words.getUniqueWords(), HttpStatus.OK);
        else
            throw new CustomExeption("No unique words found", HttpStatus.NOT_FOUND);
    }
}
