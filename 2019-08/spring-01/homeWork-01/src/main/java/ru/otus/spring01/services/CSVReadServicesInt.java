package ru.otus.spring01.services;

import java.io.IOException;
import java.util.List;

@FunctionalInterface
public interface CSVReadServicesInt {
    public List<String[]> doRead() throws IOException;

}
