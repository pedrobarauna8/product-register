package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        var scanner = new Scanner(System.in);
        var menu = new Menu();

        System.out.print("""
                Escolha uma opção:
                1 - Listar produtos
                2 - Cadastrar novo produto
                3 - Editar produto
                4 - Excluir
                5 - Sair
                """);

        var selection = scanner.nextInt();

        menu.executeMenu(selection);
    }
}