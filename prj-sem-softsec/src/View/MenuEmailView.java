package View;

import java.util.Scanner;

public class MenuEmailView { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

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

    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua opção: ");
        return scanner.nextInt();
    }

}
