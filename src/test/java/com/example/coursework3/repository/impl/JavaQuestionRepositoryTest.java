package com.example.coursework3.repository.impl;

import com.example.coursework3.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class JavaQuestionRepositoryTest {

    private JavaQuestionRepository repository;
    private static final Question QUESTION = new Question("test", "test");
    private static final Question QUESTION1 = new Question("test1", "test1");
    private static final Question QUESTION2 = new Question("test2", "test2");

    @BeforeEach
    void setUp() {
        repository = new JavaQuestionRepository();
        repository.add(QUESTION1);
        repository.add(QUESTION2);
    }


    @Test
    void add() {
        repository.add(QUESTION);
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION);
        assertEquals(repository.getAll(), excepted);
    }


    @Test
    void testAddSameObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        repository.add(QUESTION1);
        assertEquals(repository.getAll(), excepted);

    }

    @Test
    void remove() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        repository.remove(QUESTION2);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void removeNonExistedObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        repository.remove(QUESTION);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void getAll() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        assertEquals(repository.getAll(), excepted);
    }

    @Test
    void getAllEmptySet() {
        Set<Question> excepted = new HashSet<>();
        repository.remove(QUESTION1);
        repository.remove(QUESTION2);
        assertEquals(repository.getAll(), excepted);
    }
}