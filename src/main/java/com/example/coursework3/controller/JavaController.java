package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.impl.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class JavaController {
    private final JavaQuestionService questionService;

    public JavaController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return this.questionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return this.questionService.remove(new Question(question, answer));
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return this.questionService.getAll();
    }
}
