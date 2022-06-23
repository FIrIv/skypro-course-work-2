package pro.sky.skyprocoursework2.service.impl;
import org.springframework.stereotype.Service;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.service.QuestionService;

import java.util.Set;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService (MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    private java.util.Random random = new java.util.Random();

    @Override
    public Question add (String question, String answer) {
        return this.mathQuestionRepository.add(question, answer);
    }

    @Override
    public Question add (Question question) {
        return this.mathQuestionRepository.add(question);
    }
    @Override
    public Question remove (Question question) {
        return this.mathQuestionRepository.remove(question);
    }
    @Override
    public Set<Question> getAll () {
        return this.mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(mathQuestionRepository.getAll().size());
        return this.mathQuestionRepository.getAll().stream().toList().get(index);
    }
}
