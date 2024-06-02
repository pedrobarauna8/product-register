package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.model.Product;

import java.io.IOException;
import java.math.BigDecimal;

import static org.example.operations.CsvOperations.*;
import static org.example.operations.IoOperations.input;

public class EditProduct implements EventMenu {
    @Override
    public void execute(Object object) throws IOException {

        var code = input("Qual o Cod?: ", Long.class);

        var product = findById(code);

        System.out.println(product);

        var name = input("Nome: ", String.class);

        var value = input("Valor: ", BigDecimal.class);

        var quantity = input("Quantidade: ", Long.class);

        var editedProduct = new Product(code, name, value, quantity);

        var products = findAllWithoutThisId(code);

        save(products, editedProduct);

    }
}
