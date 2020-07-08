package com.kadrico.wordcounter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class WordCounterRequest {

    @NotNull
    @Size(min = 1, max = 30, message = "Word length must be between 1 and 30 characters")
    private String word;

    @NotNull
    @Size(max = 1000000, message = "Text size larger than one million characters")
    private String text;

    public String getWord() {
        return word;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
