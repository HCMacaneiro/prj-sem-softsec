package View;

import java.util.Scanner;

public class SignUpView { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

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
        System.out.print("Insira a sua senha (pelo menos 8 caracteres, pelo menos 1 número, " +
                "pelo menos 1 caracter especial, " +
                "pelo menos 1 letra maiúscula " +
                "e pelo menos 1 letra minúscula): ");
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

