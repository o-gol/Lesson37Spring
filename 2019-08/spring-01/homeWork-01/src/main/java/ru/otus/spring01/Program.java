package ru.otus.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.services.TestingServices;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("spring-context.xml");
        TestingServices test=context.getBean(TestingServices.class);

        /*TestingServices test=new TestingServices(
                new CSVReadServices("D:\\Java" +
                        "\\[OTUS] Разработчик на Spring Framework" +
                        "\\Lesson37Spring" +
                        "\\2019-08" +
                        "\\spring-01" +
                        "\\homeWork-01" +
                        "\\src" +
                        "\\main" +
                        "\\resources" +
                        "\\questions.csv"));*/

        System.out.println(test.test());
    }
}
