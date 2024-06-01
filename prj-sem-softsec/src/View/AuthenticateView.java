package View;

import java.util.Scanner;

public class AuthenticateView {

    public void displayLoginCredentials() {
        System.out.println("=====================");
        System.out.println("Login");
        System.out.println("=====================");
        System.out.print("Insira o seu e-mail: ");
    }

    public String getEmail() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayPasswordPrompt() {
        System.out.print("Insira a sua senha: ");
    }

    public String getPassword() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void displayAuthenticationResult(boolean success) {
        if (success) {
            System.out.println("Autenticação realizada com sucesso!");
        } else {
            System.out.println("Autenticação falhou. Por favor, tente novamente.");
        }
    }
}

