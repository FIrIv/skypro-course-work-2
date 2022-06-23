package pro.sky.skyprocoursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.service.QuestionService;
import pro.sky.skyprocoursework2.service.impl.JavaQuestionService;

import java.util.Set;

@RestController
@RequestMapping (path = "/java")
public class JavaQuestionController {

    @Qualifier("JavaQuestionService")
    private final QuestionService javaQuestionService;

    public JavaQuestionController (JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Set<Question> getAllQuestions () {
        return javaQuestionService.getAll();
    }

    @GetMapping(path ="/add")
    public Question addQuestion (@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path ="/remove")
    public Question removeQuestion (@RequestParam("question") String question,
                                    @RequestParam("answer") String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }
}