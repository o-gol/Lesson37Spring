package ru.otus.spring01.services;

import ru.otus.spring01.domain.Student;

import java.io.IOException;
@FunctionalInterface
public interface TestingServicesInt {
    public Student test() throws IOException;
}
