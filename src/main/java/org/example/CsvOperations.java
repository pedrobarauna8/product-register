package org.example;

import org.example.entity.ProductEntity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.IoOperations.getReader;

public class CsvOperations implements Operations{
    @Override
    public ArrayList<ProductEntity> findAll() throws FileNotFoundException {
        var reader = getReader("product.csv");
        var content = reader.lines().toList();
        var list = new ArrayList<ProductEntity>();
        for (String line : content){
            var product = Arrays.stream(line.split(",")).toList();
            var productEntity = ProductEntity.csvToObject(product);
            list.add(productEntity);
        }
        return list;
    }

    @Override
    public ProductEntity findById(Long id) throws FileNotFoundException {

        var reader = getReader("product.csv");

        var content = reader.lines().toList();

        for (String line : content) {
            var product = Arrays.stream(line.split(",")).toList();
            var productEntity = ProductEntity.csvToObject(product);
            if (productEntity.getId().equals(id)) {
                return productEntity;
            }
        }
        return null;
    }
}
