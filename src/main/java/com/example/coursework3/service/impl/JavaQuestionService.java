package com.example.coursework3.service.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.repository.QuestionRepository;
import com.example.coursework3.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questions;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questions) {
        this.questions = questions;
    }


    @Override
    public Question add(String question, String answer) {
        validateString(question);
        validateString(answer);
        Question temp = new Question(question, answer);
        questions.add(temp);
        return temp;
    }

    @Override
    public Question add(Question question) {
        validateQuestion(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        validateQuestion(question);
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.getAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        Random random = new Random();
        Object[] temp = questions.getAll().toArray();
        return (Question) temp[random.nextInt(temp.length)];
    }

    @Override
    public int getSize() {
        return questions.getAll().size();
    }

    private void validateQuestion(Question question) {
        if (question == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    private void validateString(String s) {
        if (s == null || s.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
