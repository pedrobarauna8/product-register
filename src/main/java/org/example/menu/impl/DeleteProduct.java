package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.operations.CsvOperations;

import java.io.IOException;

import static org.example.operations.IoOperations.input;

public class DeleteProduct implements EventMenu {

    @Override
    public void execute(Object object) throws IOException {

        final String file = "product.csv";

        var csvOperations = new CsvOperations(file);

        var code = input("Qual o cód?: ", Long.class);

        var products = csvOperations.findAllWithoutThisId(code);

        csvOperations.save(products);
    }
}
