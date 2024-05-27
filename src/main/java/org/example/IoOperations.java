package org.example;

import java.io.*;

public class IoOperations {
    public static BufferedReader getReader(String file) throws FileNotFoundException {
        var fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    public static BufferedWriter getWriter(String file) throws IOException {
        var fileWrite = new FileWriter(file);
        return new BufferedWriter(fileWrite);
    }
}
