package org.example;

import java.io.IOException;

import static org.example.menu.Menu.executeMenu;
import static org.example.operations.IoOperations.input;

public class Main {
    public static void main(String[] args) throws IOException {

        Integer selection = 0;

        while (selection != 5) {

            selection = input("""
                    Escolha uma opção:
                    1 - Listar produtos
                    2 - Cadastrar novo produto
                    3 - Editar produto
                    4 - Excluir
                    5 - Sair
                    """, Integer.class);

            executeMenu(selection);
        }
    }
}