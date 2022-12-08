package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private static final Question QUESTION1 = new Question("test", "test");
    private static final Question QUESTION2 = new Question("2 + 2", " = 4");
    private final QuestionService questionService1 = mock(JavaQuestionService.class);
    private final QuestionService questionService2 = mock(MathQuestionService.class);
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(questionService1, questionService2);

    @BeforeEach
    void setUp() {
        when(questionService1.getRandomQuestion()).thenReturn(QUESTION1);
        when(questionService2.getRandomQuestion()).thenReturn(QUESTION2);
    }

    @Test
    void getQuestions() {
        Set<Question> excepted = Set.of(QUESTION1, QUESTION2);
        assertEquals(excepted, examinerService.getQuestions(2));
    }
}