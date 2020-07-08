package com.kadrico.wordcounter.controller;

import com.kadrico.wordcounter.dto.WordCounterRequest;
import com.kadrico.wordcounter.dto.WordCounterResponse;
import com.kadrico.wordcounter.util.WordCounter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WordCounterController {

    @PostMapping(value = "/count", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WordCounterResponse count(@Valid @RequestBody WordCounterRequest body) {
        int count = new WordCounter(body.getText(), body.getWord()).count();
        return new WordCounterResponse(count);
    }

}
