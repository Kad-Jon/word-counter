package com.kadrico.wordcounter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    private String text;
    private String word;

    public WordCounter(String text, String word) {
        this.text = text;
        this.word = word;
    }

    public int count() {
        Pattern pattern = Pattern.compile(String.format("\\b%s\\b", word), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while(matcher.find()) count++;

        return count;
    }
}
