package org.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public record Product(Long id, String name, BigDecimal value, Long quantity) {

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", name='" + name + '\'' + ", value=" + value + ", quantity=" + quantity + '}';
    }

    public String toCsv() {
        return id + "," + name + "," + value + "," + quantity;
    }

    public static Product csvToObject(List<String> product) {
        return new Product(Long.valueOf(product.get(0)), product.get(1), new BigDecimal(product.get(2)), Long.valueOf(product.get(3)));
    }

    public static void listProductsFormatted(ArrayList<Product> products) {

        String biggerName = "";
        String biggerValue = "";
        String biggerQuantity = "";
        String line2;

        for (Product product : products) {
            if (product.name().length() > biggerName.length()) {
                biggerName = product.name();
            }
            if (String.valueOf(product.value()).length() > biggerValue.length()) {
                biggerValue = String.valueOf(product.value());
            }
            if (String.valueOf(product.quantity()).length() > biggerQuantity.length()) {
                biggerQuantity = String.valueOf(product.quantity());
            }
        }

        var nameSize = biggerName.length() + 3;
        var valueSize = biggerValue.length() + 3;
        var quantitySize = biggerQuantity.length() + 3;


        String line1 = "+" + "-".repeat(nameSize) + "+" + "-".repeat(valueSize) + "+" + "-".repeat(quantitySize) + "+\n";
        System.out.print(line1);
        System.out.print("|" + "nome" + " ".repeat(nameSize - 4) + "|" + "valor" + " ".repeat(valueSize - 5) + "|" + "qt" + " ".repeat(quantitySize - 2) + "|\n");

        for (Product product : products) {
            var valueString = String.valueOf(product.value());
            var quantityString = String.valueOf(product.quantity());
            int count = nameSize - product.name().length();
            int count1 = valueSize - valueString.length();
            int count2 = quantitySize - quantityString.length();
            line2 = "|" + product.name() + " ".repeat(count) + "|" + product.value() + " ".repeat(count1) + "|" + product.quantity() + " ".repeat(count2) + "|\n";
            System.out.print(line1 + line2);
        }

        System.out.println(line1);
    }
}
