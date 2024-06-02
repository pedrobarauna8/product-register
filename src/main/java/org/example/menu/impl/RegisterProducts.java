package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.model.Product;

import java.io.IOException;
import java.math.BigDecimal;

import static org.example.operations.CsvOperations.findAll;
import static org.example.operations.CsvOperations.save;
import static org.example.operations.IoOperations.input;

public class RegisterProducts implements EventMenu {
    @Override
    public void execute(Object object) throws IOException {

        var name = input("Nome: ", String.class);

        var value = input("Valor: ", BigDecimal.class);

        var quantity = input("Quantidade: ", Long.class);

        var products = findAll();

        var id = products.size() + 1L;

        var newProduct = new Product(id, name, value, quantity);

        System.out.println(newProduct);

        save(products, newProduct);

    }
}
