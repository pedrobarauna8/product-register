package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.model.Product;
import org.example.operations.CsvOperations;

import java.io.IOException;
import java.math.BigDecimal;

import static org.example.operations.IoOperations.input;

public class RegisterProducts implements EventMenu {

    @Override
    public void execute(Object object) throws IOException {

        final String file = "product.csv";

        var csvOperations = new CsvOperations(file);

        var name = input("Nome: ", String.class);

        var value = new BigDecimal(input("Valor: ", String.class));

        var quantity = Long.valueOf(input("Quantidade: ", String.class));

        var products = csvOperations.findAll();

        var id = products.size() + 1L;

        var newProduct = new Product(id, name, value, quantity);

        System.out.println(newProduct);

        csvOperations.save(products, newProduct);

    }
}
