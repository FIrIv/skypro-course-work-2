package pro.sky.skyprocoursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.exception.BadRequestException;
import pro.sky.skyprocoursework2.service.ExaminerService;
import pro.sky.skyprocoursework2.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl (QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set <Question> temp = new HashSet<>();
        int tempAmount = 0;
        if (questionService.getAll().size() < amount) {
            throw new BadRequestException();
        }
        while (tempAmount<amount) {
            Question q = questionService.getRandomQuestion();
            if (!temp.contains(q)) {
                temp.add(q);
                tempAmount++;
            }
        }
        return temp;
    }
}
