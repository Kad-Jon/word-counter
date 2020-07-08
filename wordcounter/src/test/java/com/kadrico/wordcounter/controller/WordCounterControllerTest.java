package com.kadrico.wordcounter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kadrico.wordcounter.dto.WordCounterRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WordCounterController.class)
class WordCounterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenContentValidThenReturnOkStatus() throws Exception {
        WordCounterRequest requestContent = new WordCounterRequest();
        requestContent.setText("test");
        requestContent.setWord("test");

        this.mockMvc.perform(post("/count")
                .content(objectMapper.writeValueAsString(requestContent))
                .contentType("application/json"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void whenRequestValidThenReturnContentIsJSON() throws Exception {
        WordCounterRequest requestContent = new WordCounterRequest();
        requestContent.setText("test");
        requestContent.setWord("test");

        this.mockMvc.perform(post("/count")
                .content(objectMapper.writeValueAsString(requestContent))
                .contentType("application/json"))
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void whenRequestInvalidThenReturnBadRequest() throws Exception {
        String request = "goo goo gaa gaa";

        this.mockMvc.perform(post("/count")
                .content(request)
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenWordEmptyThenReturnValidationError() throws Exception {
        WordCounterRequest requestContent = new WordCounterRequest();
        requestContent.setText("");
        requestContent.setWord("");

        this.mockMvc.perform(post("/count")
                .content(objectMapper.writeValueAsString(requestContent))
                .contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void whenWordNullReturnValidationError() throws Exception {
        WordCounterRequest requestContent = new WordCounterRequest();
        requestContent.setText("test");
        requestContent.setWord(null);

        this.mockMvc.perform(post("/count")
                .content(objectMapper.writeValueAsString(requestContent))
                .contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void whenTextNullReturnValidationError() throws Exception {
        WordCounterRequest requestContent = new WordCounterRequest();
        requestContent.setText(null);
        requestContent.setWord("test");

        this.mockMvc.perform(post("/count")
                .content(objectMapper.writeValueAsString(requestContent))
                .contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void whenWordLargerThanThirtyThenReturnValidationError() throws Exception {
        WordCounterRequest requestContent = new WordCounterRequest();
        requestContent.setText("test");
        String bigWord = String.format("%0" + 31 + "d", 0);
        requestContent.setWord(bigWord);


        this.mockMvc.perform(post("/count")
                .content(objectMapper.writeValueAsString(requestContent))
                .contentType("application/json"))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}