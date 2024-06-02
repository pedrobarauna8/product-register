package org.example.model;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private BigDecimal value;
    private Long quantity;

    public Product(Long id, String name, BigDecimal value, Long quantity) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }

    public String toCsv() {
        return id + "," + name + "," + value + "," + quantity;
    }

    public Long getId() {
        return id;
    }

    public static Product csvToObject(List<String> product) {
        return new Product(
                Long.valueOf(product.get(0)),
                product.get(1),
                new BigDecimal(product.get(2)),
                Long.valueOf(product.get(3)));
    }
}
