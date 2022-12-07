package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private static final Question QUESTION = new Question("test", "test");

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {

        when(questionService.getSize()).thenReturn(3);
    }

    @Test
    void getQuestions() {
        when(questionService.getRandomQuestion()).thenReturn(QUESTION);
        Set<Question> excepted = Set.of(QUESTION);
        assertEquals(excepted, examinerService.getQuestions(1));
    }

    @Test
    void getQuestionsExtendBound() {
        assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(5));
    }


}