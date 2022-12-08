package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.repository.impl.JavaQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Mock
    private JavaQuestionRepository questions;
    private static final Question QUESTION1 = new Question("test1", "test1");
    private static final Question QUESTION2 = new Question("test2", "test2");
    private final Collection<Question> setQuestion = Set.of(QUESTION1, QUESTION2);

    @Test
    void addObject() {
        when(questions.add(QUESTION2)).thenReturn(QUESTION2);
        assertEquals(javaQuestionService.add(QUESTION2), QUESTION2);
    }

    @Test
    void add() {
        when(questions.add(new Question("test2", "test2"))).thenReturn(QUESTION2);
        assertEquals(javaQuestionService.add("test2", "test2"), QUESTION2);
    }

    @Test
    void remove() {
        when(questions.remove(QUESTION2)).thenReturn(QUESTION2);
        assertEquals(javaQuestionService.remove(QUESTION2), QUESTION2);
    }

    @Test
    void getAll() {
        when(questions.getAll()).thenReturn(setQuestion);
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getAllEmptySet() {
        Set<Question> excepted = new HashSet<>();
        when(questions.getAll()).thenReturn(new HashSet<>());
        assertEquals(javaQuestionService.getAll(), excepted);
    }

    @Test
    void getRandomQuestion() {
        when(questions.getAll()).thenReturn(setQuestion);
        Question temp = javaQuestionService.getRandomQuestion();
        assertTrue(temp.equals(QUESTION1) || temp.equals(QUESTION2));
    }

    @Test
    void getRandomQuestionEmptySet() {
        when(questions.getAll()).thenReturn(new HashSet<>());
        assertThrows(ResponseStatusException.class, () -> javaQuestionService.getRandomQuestion());
    }

    @Test
    void getSize() {
        when(questions.getAll()).thenReturn(setQuestion);
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