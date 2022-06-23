package pro.sky.skyprocoursework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.exception.MethodNotAllowedException;
import pro.sky.skyprocoursework2.service.impl.MathQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathQuestionServiceTest {

    private MathQuestionService out = new MathQuestionService();

    @Test
    public void addShouldMethodNotAllowesException () {
        assertThrows(MethodNotAllowedException.class, () -> {
            String q1 = "Сколько дней в високосном году?";
            String a1 = "366";
            out.add(q1, a1);
        });
    }

    @Test
    public void addObjectShouldMethodNotAllowesException () {
        assertThrows(MethodNotAllowedException.class, () -> {
            String q1 = "Сколько дней в високосном году?";
            String a1 = "366";
            Question expected = new Question (q1, a1);
            out.add(expected);
        });
    }

    @Test
    public void removeShouldMethodNotAllowesException () {
        assertThrows(MethodNotAllowedException.class, () -> {
            String q1 = "Сколько дней в високосном году?";
            String a1 = "366";
            Question expected = new Question (q1, a1);
            out.remove(expected);
        });
    }

    @Test
    public void getRandomQuestion () {
        Question test = null;
        test = out.getRandomQuestion();
        Assertions.assertNotNull(test);
    }
}

