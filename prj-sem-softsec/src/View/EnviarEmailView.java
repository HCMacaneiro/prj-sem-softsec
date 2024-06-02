package View;

import java.util.Scanner;

public class EnviarEmailView {

    Scanner scanner;

    public EnviarEmailView(){
        this.scanner = new Scanner(System.in);
    }

    public void displayEmailSubject() {
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");
        System.out.print("Insira o assunto: ");
    }

    public String getSubject() {
        return scanner.nextLine();
    }

    public void displayEmailBody() {
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");
        System.out.print("Insira o assunto: ");
    }

    public String getBody() {
        return scanner.nextLine();
    }

    public void displayEmailRecipient() {
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");
        System.out.print("Insira o assunto: ");
    }

    public int getRecipient() {
        return scanner.nextInt();
    }

}
