package View;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

public class EnviarEmailView { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private Scanner scanner;

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
        return normalizeString(scanner.nextLine()); // IDS01-J: Normalização de strings antes da validação
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
        return normalizeString(scanner.nextLine()); // IDS01-J: Normalização de strings antes da validação
    }

    public void displayEmailRecipient(ArrayList<Integer> id_array, ArrayList<String> email_array) {
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Enviar Email");
        System.out.println("=====================");

        System.out.println("Listando ID - Email, dos usuários");

        for (int i = 0; i < id_array.size(); i++){
            System.out.println("ID: " + id_array.get(i) + " - Email: " + email_array.get(i));
        }

        System.out.println("=====================");
        System.out.println("Insira o ID do destinatário: ");
    }

    public int getRecipient() {
        int recipient_id = 0;
        try {
            recipient_id = Integer.parseInt(scanner.nextLine()); // IDS01-J: Normalização de strings antes da validação
        } catch (NumberFormatException e) {
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            System.err.println("ID do destinatário inválido. Por favor, insira um número válido.");
        }
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
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            System.err.println("Erro ao retornar ao menu: " + e.getMessage());
        }
    }

    private String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFC); // IDS01-J: Normalização de strings antes da validação
    }
}
