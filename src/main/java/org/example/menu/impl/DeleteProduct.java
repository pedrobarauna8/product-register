package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.operations.CsvOperations;

import java.io.IOException;

import static org.example.operations.IoOperations.input;

public class DeleteProduct implements EventMenu {

    public static final String FILE = "product.csv";

    @Override
    public void execute(Object object) throws IOException {

        var csvOperations = new CsvOperations(FILE);

        var code = input("Qual o cód?: ", Long.class);

        var products = csvOperations.findAllWithoutThisId(code);

        csvOperations.save(products);
    }
}
