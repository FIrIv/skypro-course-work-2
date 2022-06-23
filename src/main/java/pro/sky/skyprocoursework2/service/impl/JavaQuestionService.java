package pro.sky.skyprocoursework2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.exception.BadInputDataException;
import pro.sky.skyprocoursework2.exception.ItemNotFoundException;
import pro.sky.skyprocoursework2.service.QuestionService;

import java.util.HashSet;
import java.util.Set;
@Service
public class JavaQuestionService implements QuestionService {
    private final Set <Question> questions;
    private final java.util.Random random = new java.util.Random();

    public JavaQuestionService () {
        this.questions = new HashSet<Question>();
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new BadInputDataException();
        }
        Question temp = new Question (question, answer);
        this.questions.add(temp);
        return temp;
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NullPointerException();
        }
        if (question.getQuestion()==null || question.getAnswer()==null) {
            throw new BadInputDataException();
        }
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question == null) {
            throw new NullPointerException();
        }
        if (question.getQuestion()==null || question.getAnswer()==null) {
            throw new BadInputDataException();
        }
        if (!this.questions.contains(question)) {
            throw new ItemNotFoundException();
        }
        this.questions.remove(question);
        return question;
    }

    @Override
    public Set<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(this.questions.size());
        return this.questions.stream().toList().get(index);
    }
}
