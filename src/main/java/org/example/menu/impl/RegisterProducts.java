package org.example.menu.impl;

import org.example.CsvOperations;
import org.example.menu.EventMenu;
import org.example.entity.ProductEntity;

import java.io.*;
import java.util.Scanner;

import static org.example.IoOperations.getReader;
import static org.example.IoOperations.getWriter;

public class RegisterProducts implements EventMenu {
    @Override
    public void execute(Object object) throws IOException {

        var scanner = new Scanner(System.in);
        var csvOperations = new CsvOperations();

        var reader = getReader("product.csv");

        var content = reader.lines().toList();

        var writer = getWriter("product.csv");

        System.out.println("Nome: ");
        var name = scanner.nextLine();

        System.out.println("Valor: ");
        var value = scanner.nextBigDecimal();

        System.out.println("Quantidade: ");
        var quantity = scanner.nextLong();

        scanner.close();

        var newProduct = new ProductEntity(1L, name, value, quantity);

        System.out.println(newProduct);

        csvOperations.findAll().forEach(product -> {
            try {
                writer.write(product.toCsv());
                writer.newLine();
            } catch (IOException ignored) {}
        });

        writer.write(newProduct.toCsv());

        writer.close();

    }
    /*
    public static Object input(String print){ //TODO IMPLEMENTAR
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
     */
}
