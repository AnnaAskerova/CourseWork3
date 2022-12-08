package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {
    private static final Question QUESTION2 = new Question("2 + 2", " = 4");
    private final MathQuestionService questionService = new MathQuestionService();

    @Test
    void add() {
        assertThrows(ResponseStatusException.class, () -> questionService.add(QUESTION2));
    }

    @Test
    void addStrings() {
        assertThrows(ResponseStatusException.class, () -> questionService.add("2 + 2", " = 4"));
    }

    @Test
    void remove() {
        assertThrows(ResponseStatusException.class, () -> questionService.remove(QUESTION2));
    }

    @Test
    void getAll() {
        assertThrows(ResponseStatusException.class, questionService::getAll);
    }

    @Test
    void getSize() {
        assertThrows(ResponseStatusException.class, questionService::getSize);
    }

    @Test
    void getRandom() {
        assertNotNull(questionService.getRandomQuestion());
    }

    @Test
    void getRandomAnswer() {
        assertTrue(questionService.getRandomQuestion().getAnswer() instanceof String);
    }

    @Test
    void getRandomAsk() {
        assertTrue(questionService.getRandomQuestion().getQuestion() instanceof String);
    }
}