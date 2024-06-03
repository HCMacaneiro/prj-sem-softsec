package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInicialView {

    public void displayMenu() {
        System.out.println("=====================");
        System.out.println("Servidor de e-mail seguro");
        System.out.println("=====================");
        System.out.println("1. Login");
        System.out.println("2. Cadastrar");
        System.out.println("3. Sair");
    }

    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua opção: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            return getUserInput();
        }
    }
}


