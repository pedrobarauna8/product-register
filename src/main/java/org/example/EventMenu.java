package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface EventMenu<T, K> {
    void execute(T object) throws IOException;
    K getStrategyType();
}
