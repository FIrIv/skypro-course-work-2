package pro.sky.skyprocoursework2.service;
import pro.sky.skyprocoursework2.data.Question;

import java.util.Set;

public interface QuestionRepository {
    Question add (String question, String answer);
    Question add (Question question);
    Question remove (Question question);
    Set<Question> getAll ();
}
