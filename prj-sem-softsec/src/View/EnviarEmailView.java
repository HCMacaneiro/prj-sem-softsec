package View;

import java.util.ArrayList;
import java.util.Scanner;

public class EnviarEmailView {

    Scanner scanner;

    public EnviarEmailView(){
        this.scanner = new Scanner(System.in);
    }

    public void displayEmailSubject() {
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");
        System.out.println("Insira o assunto: ");
    }

    public String getSubject() {
        return scanner.nextLine();
    }

    public void displayEmailBody() {
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");
        System.out.println("Insira o corpo do email: ");
    }

    public String getBody() {
        return scanner.nextLine();
    }

    public void displayEmailRecipient(ArrayList<Integer> id_array, ArrayList<String> email_array) {
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");

        System.out.println("Listando ID - Email, dos usuários");

        for (int i = 0; i <= (id_array.size() - 1); i++){
            System.out.println("ID: " + id_array.get(i) + " - Email: " + email_array.get(i));
        }

        System.out.println("=====================");
        System.out.println("Insira o ID do destinatário: ");
    }

    public int getRecipient() {
        int recipient_id = scanner.nextInt();
        scanner.nextLine();
        return recipient_id;
    }

    public void displayEmailEnviado(){
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Email Enviado! Retornando ao menu...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
