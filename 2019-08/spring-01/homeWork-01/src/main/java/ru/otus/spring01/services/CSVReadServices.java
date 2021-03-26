package ru.otus.spring01.services;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReadServices implements CSVReadServicesInt {
    private final String path;

    public CSVReadServices(String path) {
        this.path = path;
    }

    public  List<String[]> doRead() throws IOException{
        CSVReader reader=new CSVReader(new FileReader(path));
        List<String[]> list=new ArrayList<>();
        String[] nextLine;
        while ((nextLine=reader.readNext())!=null) {
            list.add(nextLine);
        }
        return list;



    }


}
