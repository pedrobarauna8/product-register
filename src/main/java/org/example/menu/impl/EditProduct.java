package org.example.menu.impl;

import org.example.CsvOperations;
import org.example.menu.EventMenu;

import java.io.IOException;
import java.util.Scanner;

public class EditProduct implements EventMenu {
    @Override
    public void execute(Object object) throws IOException {

        var scanner = new Scanner(System.in);
        var operation = new CsvOperations();

        System.out.println("Qual o Cod?: ");
        var code = scanner.nextLong();

        var product = operation.findById(code);

        System.out.println(product);

    }
}
