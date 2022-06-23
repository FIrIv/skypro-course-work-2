package pro.sky.skyprocoursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.service.impl.ExaminerServiceImpl;

import java.util.Set;

@RestController
public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController (ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Set<Question> getQuestions (@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
