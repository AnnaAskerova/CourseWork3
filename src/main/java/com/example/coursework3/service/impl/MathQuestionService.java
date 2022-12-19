package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Question add(Question question) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Question remove(Question question) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Collection<Question> getAll() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);
        int c = random.nextInt(4);
        int answer = 0;
        String sign = "";
        switch (c) {
            case 0 -> {
                sign = " + ";
                answer = a + b;
            }
            case 1 -> {
                sign = " - ";
                answer = a - b;
            }
            case 2 -> {
                sign = " / ";
                answer = a / b;
            }
            case 3 -> {
                sign = " * ";
                answer = a * b;
            }
            default -> {
            }
        }
        return new Question(a + sign + b, " = " + answer);
    }

    @Override
    public int getSize() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
