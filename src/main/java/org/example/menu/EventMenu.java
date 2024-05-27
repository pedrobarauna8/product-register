package org.example.menu;

import java.io.IOException;

public interface EventMenu<T, K> {
    void execute(T object) throws IOException;
}
