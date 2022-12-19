package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private List<QuestionService> services;

    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;

    private static final Question QUESTION1 = new Question("test", "test");
    private static final Question QUESTION2 = new Question("2 + 2", " = 4");

    @BeforeEach
    void setUp() {
        when(services.get(0)).thenReturn(javaQuestionService);
        when(services.get(1)).thenReturn(mathQuestionService);
    }

    @Test
    void getQuestions() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION2);
        Set<Question> excepted = Set.of(QUESTION1, QUESTION2);
        assertEquals(excepted, examinerService.getQuestions(2));
    }
}