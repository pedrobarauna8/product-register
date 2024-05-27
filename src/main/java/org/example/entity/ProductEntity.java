package org.example.entity;

import java.math.BigDecimal;
import java.util.List;

public class ProductEntity {
    private Long id;
    private String name;
    private BigDecimal value;
    private Long quantity;

    public ProductEntity(Long id, String name, BigDecimal value, Long quantity) {
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

    public static ProductEntity csvToObject(List<String> product) {
        return new ProductEntity(
                Long.valueOf(product.get(0)),
                product.get(1),
                new BigDecimal(product.get(2)),
                Long.valueOf(product.get(3)));
    }
}
