package View;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuEmailView {

    private final Scanner scanner;

    public MenuEmailView() {
        this.scanner = new Scanner(System.in); // Inicializar o scanner uma vez
    }

    public void displayMenu(String email) {
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Olá, " + email + "!");
        System.out.println("=====================");
        System.out.println("1. Enviar email");
        System.out.println("2. Caixa de entrada (Ler e deletar emails)");
        System.out.println("3. Sair");
    }

    public int getUserInput() throws NoSuchElementException {
        System.out.print("Digite sua opção: ");
        return scanner.nextInt();
    }

    public void limpaBufferScanner() {
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Limpa o buffer do scanner
        }
    }
}
