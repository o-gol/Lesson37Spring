package ru.otus.spring01.services;

import ru.otus.spring01.domain.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestingServices implements TestingServicesInt{
    Student student;
    CSVReadServicesInt csvReadServices;
    Scanner scanner=new Scanner(System.in);

    public TestingServices(CSVReadServicesInt csvReadServices) {
        this.csvReadServices = csvReadServices;
    }

    public Student test() throws IOException {
        System.out.println("Ваше имя");
        String name=scanner.nextLine();
        System.out.println("Ваше фамилия");
        String surname=scanner.nextLine();
        student=new Student(name,surname);
//        System.out.println(student);
        List<String[]> questions=csvReadServices.doRead();
        int trueAnswer=0;
        for (String[] line :
                questions) {
            System.out.println(line[0]);
            for (int i = 0; i < 4; i++) {
                System.out.println(line[i+1]);
            }
            int answer=scanner.nextInt();
            if(answer==Integer.parseInt(line[5])){
                trueAnswer++;
                System.out.println("true Answer");
            }else
                System.out.println("wrong Answer");
        }
        student.setRating(trueAnswer);


        return student;
    }
}
