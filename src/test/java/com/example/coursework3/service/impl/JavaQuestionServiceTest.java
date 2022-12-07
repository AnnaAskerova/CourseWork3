package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private static final Question QUESTION = new Question("test", "test");
    private static final Question QUESTION1 = new Question("test1", "test1");
    private static final Question QUESTION2 = new Question("test2", "test2");

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(QUESTION1);
        javaQuestionService.add(QUESTION2);
    }

    @Test
    void add() {
        javaQuestionService.add("test", "test");
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void addObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION);
        javaQuestionService.add(QUESTION);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void testAddSameObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        javaQuestionService.add(QUESTION1);
        assertEquals(javaQuestionService.getAll(), excepted);

    }

    @Test
    void remove() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        javaQuestionService.remove(QUESTION2);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void removeNonExistedObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        javaQuestionService.remove(QUESTION);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getAll() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getAllEmptySet() {
        Set<Question> excepted = new HashSet<>();
        javaQuestionService.remove(QUESTION1);
        javaQuestionService.remove(QUESTION2);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getRandomQuestion() {
        Question temp = javaQuestionService.getRandomQuestion();
        assertTrue(temp.equals(QUESTION1) || temp.equals(QUESTION2));
    }

    @Test
    void getRandomQuestionEmptySet() {
        javaQuestionService.remove(QUESTION1);
        javaQuestionService.remove(QUESTION2);
        assertThrows(ResponseStatusException.class, () -> javaQuestionService.getRandomQuestion());
    }

    @Test
    void getSize() {
        assertEquals(2, javaQuestionService.getSize());
    }

    @Test
    void validateString() {
        try {
            Method method = JavaQuestionService.class.getDeclaredMethod("validateString", String.class);
            method.setAccessible(true);
            method.invoke(javaQuestionService, (Object) null);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(ResponseStatusException.class, e.getCause().getClass());
        }
    }

    @Test
    void validateQuestion() {
        try {
            Method method = JavaQuestionService.class.getDeclaredMethod("validateQuestion", Question.class);
            method.setAccessible(true);
            method.invoke(javaQuestionService, (Object) null);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(ResponseStatusException.class, e.getCause().getClass());
        }
    }
}