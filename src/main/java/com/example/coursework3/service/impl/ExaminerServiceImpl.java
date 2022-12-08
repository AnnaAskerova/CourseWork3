package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerService;
import com.example.coursework3.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> services;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService1,
                               @Qualifier("mathQuestionService") QuestionService questionService2) {
        services = List.of(questionService1, questionService2);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Random random = new Random();
        Collection<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            int a = random.nextInt(2);
            questions.add(services.get(a).getRandomQuestion());
        }
        return questions;
    }
}
