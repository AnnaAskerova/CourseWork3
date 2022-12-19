package com.example.coursework3.repository.impl;

import com.example.coursework3.model.Question;
import com.example.coursework3.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Collection<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("test1", "test1"));
        questions.add(new Question("test2", "test2"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
