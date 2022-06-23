package pro.sky.skyprocoursework2.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.exception.BadRequestException;
import pro.sky.skyprocoursework2.service.ExaminerService;
import pro.sky.skyprocoursework2.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final java.util.Random random = new java.util.Random();
    private int countJavaQ;
    private int countMathQ;

    @Qualifier ("JavaQuestionService")
    private final QuestionService javaQuestionService;

    @Qualifier ("MathQuestionService")
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl (JavaQuestionService javaQuestionService,
                                MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set <Question> temp = new HashSet<>();
        int tempAmount = 0;

        generateCountsJavaMathQuestions (amount);

        while (tempAmount<this.countJavaQ) {
            Question q = javaQuestionService.getRandomQuestion();
            if (!temp.contains(q)) {
                temp.add(q);
                tempAmount++;
            }
        }

        while (tempAmount<this.countJavaQ + this.countMathQ) {
            Question q = mathQuestionService.getRandomQuestion();
            if (!temp.contains(q)) {
                temp.add(q);
                tempAmount++;
            }
        }

        return temp;
    }

    private void generateCountsJavaMathQuestions (int amount) {
        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < amount) {
            throw new BadRequestException();
        }

        this.countJavaQ = random.nextInt(amount);
        if (this.countJavaQ>javaQuestionService.getAll().size()) {
            this.countJavaQ = javaQuestionService.getAll().size();
        }

        this.countMathQ = amount - this.countJavaQ;
        if (countMathQ>mathQuestionService.getAll().size()) {
            this.countJavaQ += this.countMathQ - mathQuestionService.getAll().size();
            this.countMathQ = mathQuestionService.getAll().size();
        }
    }
}
