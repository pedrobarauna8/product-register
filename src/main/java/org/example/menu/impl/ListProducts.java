package org.example.menu.impl;

import org.example.menu.EventMenu;

import java.io.IOException;

import static org.example.operations.CsvOperations.findAll;

public class ListProducts implements EventMenu {
    @Override
    public void execute(Object object) throws IOException {
        findAll().forEach(System.out::println);
    }
/*
    public String listProductsFormatted(ArrayList<Product> products) {

        AtomicReference<String> bigger = new AtomicReference<>("");

        products.forEach(product -> {
            if (product.getName().length() > bigger.get().length()) {
                bigger.set(product.getName());
            }
        });

        System.out.println(bigger.get().length());

        var nameSize = name.length() + 3;
        var valueString = String.valueOf(value);
        var valueSize = valueString.length() + 3;
        var quantityString = String.valueOf(quantity);
        var quantitySize = quantityString.length() + 3;
        var line = "+" + "-".repeat(nameSize) + "+" + "-".repeat(valueSize) + "+" + "-".repeat(quantitySize) + "+\n";
        var line1 = "|" + name + " ".repeat(nameSize - name.length()) + "|" + value + " ".repeat(valueSize - valueString.length()) + "|" + quantity + " ".repeat(quantitySize - quantityString.length()) + "|\n";


        return line + line1 + line;

        //TODO Terminar de implementar
    }
 */
}
