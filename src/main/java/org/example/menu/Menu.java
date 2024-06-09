package org.example.menu;

import org.example.menu.impl.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    static Map<Integer, EventMenu> implementations = new HashMap<>() {{
        put(1, new ListProducts());
        put(2, new RegisterProducts());
        put(3, new EditProduct());
        put(4, new DeleteProduct());
        put(5, new ProductsCart());
    }};

    public static void executeMenu(Integer option) throws IOException {

        if (!implementations.containsKey(option)){
            throw new IllegalArgumentException("Opção invalida");
        }

        var event = implementations.get(option);

        event.execute(option);
    }
}
