package pro.sky.skyprocoursework2;

import org.junit.jupiter.api.Test;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.exception.BadInputDataException;
import pro.sky.skyprocoursework2.exception.ItemNotFoundException;
import pro.sky.skyprocoursework2.service.impl.JavaQuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionRepositoryTest {

    private JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    public void add () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        Question expected = new Question (q1, a1);

        Question result = out.add(q1, a1);

        assertEquals(expected, result);
    }

    @Test
    public void addShouldBadInputDataException () {
        assertThrows(BadInputDataException.class, () -> {
            String s1 = null;
            String s2 = "Ответ. ";
            out.add(s1, s2);
        });
    }

    @Test
    public void addObject () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        Question expected = new Question (q1, a1);

        Question result = out.add(expected);

        assertEquals(expected, result);
    }

    @Test
    public void addObjectBadInputNullDataException () {
        assertThrows(BadInputDataException.class, () -> {
            Question temp = null;
            out.add(temp);
        });
    }

    @Test
    public void addObjectShouldBadInputDataException () {
        assertThrows(BadInputDataException.class, () -> {
            String s1 = null;
            String s2 = "Ответ. ";
            Question temp = new Question(s1, s2);
            out.add(temp);
        });
    }

    @Test
    public void remove () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        Question expected = new Question (q1, a1);

        out.add(expected);
        Question result = out.remove(expected);

        assertEquals(expected, result);
    }

    @Test
    public void removeShouldBadInputNullDataException () {
        assertThrows(BadInputDataException.class, () -> {
            Question temp = null;
            out.remove(temp);
        });
    }

    @Test
    public void removeShouldBadInputDataException () {
        assertThrows(BadInputDataException.class, () -> {
            String s1 = null;
            String s2 = "Ответ. ";
            Question temp = new Question(s1, s2);
            out.remove(temp);
        });
    }

    @Test
    public void removeShouldItemNotFoundException () {
        assertThrows(ItemNotFoundException.class, () -> {
            String q1 = "Сколько дней в високосном году?";
            String a1 = "366";
            out.add(q1,a1);
            String q2 = "Сколько дней обычно в году?";
            String a2 = "365";
            Question temp = new Question (q2, a2);
            out.remove(temp);
        });
    }

    @Test
    public void getAll () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        out.add(q1,a1);
        String q2 = "Сколько дней обычно в году?";
        String a2 = "365";
        out.add(q2,a2);
        String q3 = "Сколько дней в неделе?";
        String a3 = "7";
        out.add(q3,a3);

        Set<Question> expected = new HashSet<Question>();
        expected.add(new Question (q1,a1));
        expected.add(new Question (q2,a2));
        expected.add(new Question (q3,a3));

        Set<Question> result = out.getAll();

        assertEquals(expected, result);
    }
}
