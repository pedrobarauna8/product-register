package org.example.menu.impl;

import org.example.menu.EventMenu;
import org.example.model.Product;
import org.example.operations.CsvOperations;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.example.model.Product.listProductsFormatted;
import static org.example.operations.IoOperations.input;

public class ProductsCart implements EventMenu {

    public static final String FILE = "product.csv";

    @Override
    public void execute(Object object) throws IOException {

        var csvOperations = new CsvOperations(FILE);

        String choice = "";
        BigDecimal total = BigDecimal.ZERO;

        var cart = new ArrayList<Product>();

        while (!choice.equalsIgnoreCase("N")) {

            String name = null;
            Product product = null;
            Long quantity = Long.MAX_VALUE;

            while (product == null) {

                name = input("Produto: ", String.class);

                product = csvOperations.findByName(name);

                if (product == null || product.quantity() == 0) {
                    System.out.println("Produto indisponivel, tente novamente");
                }
            }

            while (quantity > product.quantity()) {

                quantity = input("Quantidade: ", Long.class);

                if (quantity > product.quantity()) {
                    System.out.println("Quantidade indisponivel, quantidade maxima: " + product.quantity());
                }
            }

            var subtotal = product.value().multiply(new BigDecimal(quantity));

            System.out.println("Subtotal: " + subtotal);

            total = total.add(subtotal);

            cart.add(new Product(null, name, product.value(), quantity));

            choice = input("Adicionar mais um produto? (S/N): ", String.class).toUpperCase();

        }

        for (Product p : cart){
            var oldProduct = csvOperations.findByName(p.name());
            var newProduct = new Product(oldProduct.id(), oldProduct.name(), oldProduct.value(), oldProduct.quantity() - p.quantity());
            var products = csvOperations.findAllWithoutThisId(oldProduct.id());
            csvOperations.save(products, newProduct);
        }

        listProductsFormatted(cart);
        System.out.println("Total da compra: " + total);

    }
}
