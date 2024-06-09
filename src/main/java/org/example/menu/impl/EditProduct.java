package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.model.Product;
import org.example.operations.CsvOperations;

import java.io.IOException;
import java.math.BigDecimal;

import static org.example.operations.IoOperations.input;

public class EditProduct implements EventMenu {

    public static final String FILE = "product.csv";

    @Override
    public void execute(Object object) throws IOException {

        var csvOperations = new CsvOperations(FILE);

        var code = input("Qual o Cod?: ", Long.class);

        var product = csvOperations.findById(code);

        System.out.println(product);

        var name = input("Nome: ", String.class);

        var value = new BigDecimal(input("Valor: ", String.class));

        var quantity = Long.valueOf(input("Quantidade: ", String.class));

        var editedProduct = new Product(code, name, value, quantity);

        var products = csvOperations.findAllWithoutThisId(code);

        csvOperations.save(products, editedProduct);

    }
}
