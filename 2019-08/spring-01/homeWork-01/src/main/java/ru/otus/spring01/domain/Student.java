package ru.otus.spring01.domain;

public class Student {
    private final String name;
    private final String surname;
    private int rating;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", rating=" + rating +
                '}';
    }
}
