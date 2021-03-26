package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Person;

public class PersonDaoSimple implements PersonDao {

    int defaultAge=18;

    public void setDefaultAge(int defaultAge) {
        this.defaultAge = defaultAge;
    }

    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }
}
