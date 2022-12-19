package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerService;
import com.example.coursework3.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> services;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.services = questionServices;
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
