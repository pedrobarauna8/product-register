package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.operations.CsvOperations;

import java.io.IOException;

import static org.example.model.Product.listProductsFormatted;

public class ListProducts implements EventMenu {

    public static final String FILE = "product.csv";

    @Override
    public void execute(Object object) throws IOException {

        var csvOperations = new CsvOperations(FILE);

        listProductsFormatted(csvOperations.findAll());
    }
}
