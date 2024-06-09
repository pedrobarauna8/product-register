package org.example;

import java.io.IOException;

import static org.example.menu.Menu.executeMenu;
import static org.example.operations.IoOperations.input;

public class Main {
    public static void main(String[] args) throws IOException {

        while (true) {

            Integer selection = input("""
                    Escolha uma opção:
                    1 - Listar produtos
                    2 - Cadastrar novo produto
                    3 - Editar produto
                    4 - Excluir
                    5 - Vender
                    6 - Sair
                    """, Integer.class);

            if (selection.equals(6)) break;

            try {

                executeMenu(selection);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}