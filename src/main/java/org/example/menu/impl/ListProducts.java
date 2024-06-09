package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.operations.CsvOperations;

import java.io.IOException;

import static org.example.model.Product.listProductsFormatted;

public class ListProducts implements EventMenu {

    @Override
    public void execute(Object object) throws IOException {

        final String file = "product.csv";

        var csvOperations = new CsvOperations(file);

        listProductsFormatted(csvOperations.findAll());
    }
}
