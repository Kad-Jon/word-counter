package com.kadrico.wordcounter;

import com.kadrico.wordcounter.controller.EntryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class WordCounterApplicationTests {

	@Autowired
	private EntryController entryController;

	@Test
	void contextLoads() {
		assertNotEquals(null, entryController);
	}

}
