package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/random/{amount}")
    Collection<Question> getQuestions(@PathVariable int amount) {
        return this.examinerService.getQuestions(amount);
    }
}
