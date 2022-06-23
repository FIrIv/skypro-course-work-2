package pro.sky.skyprocoursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.exception.BadRequestException;
import pro.sky.skyprocoursework2.service.ExaminerService;
import pro.sky.skyprocoursework2.service.QuestionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices = new ArrayList<>();

    public ExaminerServiceImpl (JavaQuestionService javaQuestionService,
                                MathQuestionService mathQuestionService) {
        this.questionServices.add(javaQuestionService);
        this.questionServices.add(mathQuestionService);
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set <Question> temp = new HashSet<>();

        if (this.questionServices.stream().mapToInt(e->e.getAll().size()).sum() < amount) {
            throw new BadRequestException();
        }

        while (temp.size() < amount) {
            for (int i=0; i<this.questionServices.size(); i++) {
                Question q = questionServices.get(i).getRandomQuestion();
                temp.add(q);
                if (temp.size() == amount) {
                    break;
                }
            }
        }

        return temp;
    }
}

