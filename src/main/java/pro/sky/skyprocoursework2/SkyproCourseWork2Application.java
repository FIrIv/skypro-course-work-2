package pro.sky.skyprocoursework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyproCourseWork2Application {

	public static void main(String[] args) {

		/*
			/exam?amount=5
		Выводит 5 вопросов по темам Java, математика (разбивка происходит случайным образом).
			/exam/java
		Выводит список всех вопросов по Java.
			/exam/java/add?question=Сколько будет дважды два?&answer=4
		Добавляет вопрос и ответ по Java.
			/exam/java/remove?question=Сколько будет дважды два?&answer=4
		Удаляет вопрос и ответ по Java.
			/exam/math
		Выводит список всех вопросов по математике.
			/exam/math/add?question=Сколько будет дважды два?&answer=4
		Добавляет вопрос и ответ по математике.
			/exam/math/remove?question=Сколько будет дважды два?&answer=4
		Удаляет вопрос и ответ по математике.
		*/

		SpringApplication.run(SkyproCourseWork2Application.class, args);
	}

}
