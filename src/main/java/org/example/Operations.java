package org.example;

import org.example.entity.ProductEntity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Operations {
    ArrayList<ProductEntity> findAll() throws FileNotFoundException;
    ProductEntity findById(Long id) throws FileNotFoundException;
}
