package org.example.operations;

import org.example.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.operations.IoOperations.getReader;
import static org.example.operations.IoOperations.getWriter;

public class CsvOperations {

    private final String file;

    public CsvOperations(String file) {
        this.file = file;
    }

    public ArrayList<Product> findAll() throws IOException {

        var reader = getReader(file);

        var content = reader.lines().toList();

        reader.close();

        var list = new ArrayList<Product>();
        for (String line : content) {
            var product = Arrays.stream(line.split(",")).toList();
            var productEntity = Product.csvToObject(product);
            list.add(productEntity);
        }
        return list;
    }

    public Product findById(Long id) throws IOException {

        var reader = getReader(file);

        var content = reader.lines().toList();

        reader.close();

        for (String line : content) {
            var product = Arrays.stream(line.split(",")).toList();
            var productEntity = Product.csvToObject(product);
            if (productEntity.id().equals(id)) {
                return productEntity;
            }
        }
        return null;
    }

    public ArrayList<Product> findAllWithoutThisId(Long id) throws IOException {

        var reader = getReader(file);

        var content = reader.lines().toList();

        reader.close();

        var list = new ArrayList<Product>();

        for (String line : content) {
            var product = Arrays.stream(line.split(",")).toList();
            var productEntity = Product.csvToObject(product);
            if (!productEntity.id().equals(id)) {
                list.add(productEntity);
            }
        }
        return list;
    }

    public void save(ArrayList<Product> products) throws IOException {

        var writer = getWriter(file);

        products.forEach(product -> {
            try {
                writer.write(product.toCsv());
                writer.newLine();
            } catch (IOException ignored) {
            }
        });

        writer.close();
    }

    public void save(ArrayList<Product> products, Product product) throws IOException {

        var writer = getWriter(file);

        products.forEach(p -> {
            try {
                writer.write(p.toCsv());
                writer.newLine();
            } catch (IOException ignored) {
            }
        });

        writer.write(product.toCsv());

        writer.close();
    }
}
