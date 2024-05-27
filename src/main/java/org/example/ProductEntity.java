package org.example;

import java.math.BigDecimal;

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

    public String toCsv(){
        return id + "," + name + "," + value + "," + quantity;
    }
}
