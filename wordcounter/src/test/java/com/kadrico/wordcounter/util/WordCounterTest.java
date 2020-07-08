package com.kadrico.wordcounter.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    public void countsSingleOccurrence() {
        WordCounter counter = new WordCounter("test", "test");

        int count = counter.count();

        assertEquals(1, count);
    }

    @Test
    public void countsDoubleOccurrences() {
        WordCounter counter = new WordCounter("test test", "test");

        int count = counter.count();

        assertEquals(2, count);
    }


    @Test
    public void emptyTextStringsReturnsZero() {
        WordCounter counter = new WordCounter("", "test");

        int count = counter.count();

        assertEquals(0, count);
    }

    @Test
    public void countingIsCaseInsensitive() {
        WordCounter counter = new WordCounter("Test", "test");

        int count = counter.count();

        assertEquals(1, count);
    }

    @Test
    public void doesNotCountWordInsideOtherWord() {
        WordCounter counter = new WordCounter("tester", "test");

        int count = counter.count();

        assertEquals(0, count);
    }
}