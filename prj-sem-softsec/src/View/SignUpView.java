package View;

import java.util.Scanner;

public class SignUpView {

    // Mostra o menu inicial do cadastro, pedindo o e-mail
    public void displaySignUp() {
        System.out.println("=====================");
        System.out.println("Cadastro");
        System.out.println("=====================");
        System.out.print("Insira o seu e-mail: ");
    }

    // Recebe o e-mail do usuário
    public String getEmail() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Pede a senha do usuário
    public void displayPasswordPrompt() {
        System.out.print("Insira a sua senha (pelo menos 8 caracteres, pelo menos 1 número, " +
                "pelo menos 1 caracter especial, " +
                "pelo menos 1 letra maiúscula " +
                "e pelo menos 1 letra minúscula): ");
    }

    // Recebe a senha do usuário
    public String getPassword() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Mostra o sucesso ou falha da autenticação do usuário, a depender do resultado
    public void displaySignUpResult(boolean success) {
        if (success) {
            System.out.println("Cadastro realizado com sucesso! Por favor, realize o login para continuar.");
        } else {
            System.out.println("Cadastro falhou. Por favor, tente novamente.");
        }
    }
}

