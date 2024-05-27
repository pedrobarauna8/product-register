package org.example;

import java.io.*;
import java.util.Scanner;

public class RegisterProducts implements EventMenu {
    @Override
    public void execute(Object object) throws IOException {

        var scanner = new Scanner(System.in);

        var fileReader = new FileReader("product.csv");
        var bufferedReader = new BufferedReader(fileReader);
        var content = bufferedReader.lines().toList();
        var fileWrite = new FileWriter("product.csv");
        var bufferedWrite = new BufferedWriter(fileWrite);

        System.out.println("Nome: ");
        var name = scanner.nextLine();

        System.out.println("Valor: ");
        var value = scanner.nextBigDecimal();

        System.out.println("Quantidade: ");
        var quantity = scanner.nextLong();

        scanner.close();

        var product = new ProductEntity(1L, name, value, quantity);

        System.out.println(product);

        content.forEach(line -> {
            try {
                bufferedWrite.write(line);
                bufferedWrite.newLine();
            } catch (IOException ignored) {}
        });

        bufferedWrite.write(product.toCsv());

        bufferedWrite.close();

    }

    @Override
    public Object getStrategyType() {
        return null;
    }
}
