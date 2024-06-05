package View;

import java.util.Scanner;

public class AuthenticateView {
    // Função que gera o menu de autenticação para o usuário, iniciando com o e-mail
    public void displayLoginCredentials() {
        System.out.println("=====================");
        System.out.println("Login");
        System.out.println("=====================");
        System.out.print("Insira o seu e-mail: ");
    }

    // Recebe o e-mail do usuário
    public String getEmail() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Gera menu pedindo a senha do usuário
    public void displayPasswordPrompt() {
        System.out.print("Insira a sua senha: ");
    }

    // Recebe a senha do usuário
    public String getPassword() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Retorna mensagem de sucesso ou erro para o usuário, dependendo do resultado da autenticação
    public void displayAuthenticationResult(boolean success) {
        if (success) {
            System.out.println("Autenticação realizada com sucesso!");
        } else {
            System.out.println("Autenticação falhou. Por favor, tente novamente.");
        }
    }
}

