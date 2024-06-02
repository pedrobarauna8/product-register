package org.example.menu.impl;

import org.example.menu.EventMenu;

import java.io.IOException;

import static org.example.operations.CsvOperations.findAllWithoutThisId;
import static org.example.operations.CsvOperations.save;
import static org.example.operations.IoOperations.input;

public class DeleteProduct implements EventMenu {

    @Override
    public void execute(Object object) throws IOException {

        var code = input("Qual o cód?: ", Long.class);

        var products = findAllWithoutThisId(code);

        save(products);
    }
}
