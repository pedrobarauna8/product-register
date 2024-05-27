package org.example.menu.impl;

import org.example.CsvOperations;
import org.example.menu.EventMenu;

import java.io.FileNotFoundException;

public class ListProducts implements EventMenu {
    @Override
    public void execute(Object object) throws FileNotFoundException {
        var csvOperations = new CsvOperations();
        System.out.println(csvOperations.findAll());
    }
}
