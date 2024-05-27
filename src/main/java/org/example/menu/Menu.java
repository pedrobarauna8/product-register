package org.example.menu;

import org.example.menu.impl.EditProduct;
import org.example.menu.impl.ListProducts;
import org.example.menu.impl.RegisterProducts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    static Map<Integer, EventMenu> implementations = new HashMap<>() {{
        put(1, new ListProducts());
        put(2, new RegisterProducts());
        put(3, new EditProduct());
    }};

    public void executeMenu(Integer option) throws IOException {

        var event = implementations.get(option);

        event.execute(option);
    }
}
