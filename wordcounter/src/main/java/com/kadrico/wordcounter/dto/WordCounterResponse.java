package com.kadrico.wordcounter.dto;

public class WordCounterResponse {
    private int count;

    public WordCounterResponse(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
