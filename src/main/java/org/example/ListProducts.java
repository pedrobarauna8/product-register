package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ListProducts implements EventMenu {
    @Override
    public void execute(Object object) throws FileNotFoundException {
        var fileReader = new FileReader("product.csv");
        var bufferedReader = new BufferedReader(fileReader);
        var content = bufferedReader.lines().toList();
        content.forEach(System.out::println);
    }

    @Override
    public Object getStrategyType() {
        return null;
    }
}
