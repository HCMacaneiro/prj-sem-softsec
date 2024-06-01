package View;

import java.util.Scanner;

public class SignUpView {

    public void displaySignUp() {
        System.out.println("=====================");
        System.out.println("Cadastro");
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

    public void displaySignUpResult(boolean success) {
        if (success) {
            System.out.println("Cadastro realizado com sucesso! Por favor, realize o login para continuar.");
        } else {
            System.out.println("Cadastro falhou. Por favor, tente novamente.");
        }
    }
}

