package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerService;
import com.example.coursework3.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount > this.questionService.getSize()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Collection<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(this.questionService.getRandomQuestion());
        }
        return questions;
    }
}
