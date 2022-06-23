package pro.sky.skyprocoursework2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprocoursework2.data.Question;
import pro.sky.skyprocoursework2.service.impl.JavaQuestionRepository;
import pro.sky.skyprocoursework2.service.impl.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void add () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        Question expected = new Question (q1, a1);

        Mockito.when(javaQuestionRepository.add(q1, a1)).thenReturn(expected);
        Question result = out.add(q1, a1);

        assertEquals(expected, result);
    }

    @Test
    public void addObject () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        Question expected = new Question (q1, a1);

        Mockito.when(javaQuestionRepository.add(expected)).thenReturn(expected);
        Question result = out.add(expected);

        assertEquals(expected, result);
    }

    @Test
    public void remove () {
        String q1 = "Сколько дней в високосном году?";
        String a1 = "366";
        Question expected = new Question (q1, a1);

        out.add(expected);
        Mockito.when(javaQuestionRepository.remove(expected)).thenReturn(expected);
        Question result = out.remove(expected);

        assertEquals(expected, result);
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

        Mockito.when(javaQuestionRepository.getAll()).thenReturn(expected);
        Set<Question> result = out.getAll();

        assertEquals(expected, result);
    }

    @Test
    // замокать стандартный класс Random нельзя
    // создавать собственный класс под Random не стала (хотя тогда можно было бы протестировать метод)
    // проверяю, как возвращает один из одного только
    public void getRandomQuestionOneByOne () {
        String q2 = "Сколько дней обычно в году?";
        String a2 = "365";

        Question expected = new Question (q2,a2);
        Set<Question> expectedSet = new HashSet<Question>();
        expectedSet.add(expected);

        out.add(q2,a2);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(expectedSet);
        Question result = out.getRandomQuestion();

        assertEquals(expected, result);
    }
}
