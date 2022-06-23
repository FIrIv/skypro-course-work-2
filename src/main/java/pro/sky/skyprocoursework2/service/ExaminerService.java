package pro.sky.skyprocoursework2.service;

import pro.sky.skyprocoursework2.data.Question;
import java.util.Set;

public interface ExaminerService {
    public Set<Question> getQuestions (int amount);
}
