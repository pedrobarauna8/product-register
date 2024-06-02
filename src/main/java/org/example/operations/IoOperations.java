package org.example.operations;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class IoOperations<T> {
    public static BufferedReader getReader(String file) throws FileNotFoundException {
        var fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    public static BufferedWriter getWriter(String file) throws IOException {
        var fileWrite = new FileWriter(file);
        return new BufferedWriter(fileWrite);
    }

    public static <T> T input(String print, Class<T> type) {
        System.out.print(print);
        var scanner = new Scanner(System.in);
        if (type == String.class) {
            return (T) scanner.nextLine();
        }
        if (type == Integer.class) {
            return (T) Integer.valueOf(scanner.nextInt());
        }
        if (type == BigDecimal.class) {
            return (T) scanner.nextBigDecimal();
        }
        if (type == Long.class) {
            return (T) Long.valueOf(scanner.nextLong());
        }
        scanner.close();
        return null;
    }
}
