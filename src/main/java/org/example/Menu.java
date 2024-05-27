package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    static Map<Integer, EventMenu> implementations = new HashMap<>(){{
        put(1, new ListProducts());
        put(2, new RegisterProducts());
    }};

    public void executeMenu(Integer option) throws IOException {
        var event = implementations.get(option);

        event.execute(option);
    }
}
