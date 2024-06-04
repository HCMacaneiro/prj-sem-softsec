package View;

import Controller.MenuEmailController;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

public class EnviarEmailView {

    private Scanner scanner;
    private MenuEmailController menuEmailController = new MenuEmailController();

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
        return normalizeString(scanner.nextLine()); // IDS01-J: normalização de strings antes da validação
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

        // imprime os emails
        for (int i = 0; i < id_array.size(); i++){
            System.out.println("ID: " + id_array.get(i) + " - Email: " + email_array.get(i));
        }

        System.out.println("=====================");
        System.out.println("Insira o ID do destinatário: ");
    }

    public int getRecipient(String email, int email_id) {
        int recipient_id = 0;
        try {
            recipient_id = Integer.parseInt(scanner.nextLine()); // IDS01-J: Normalização de strings antes da validação
        } catch (NumberFormatException e) {
            // ERR00-J: não suprimir ou ignorar exceções verificadas
            System.err.println("ID do destinatário inválido. Por favor, insira um número válido. Voltando ao Menu...");
            menuEmailController.handleMenu(email, email_id);
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
            // ERR00-J: não suprimir ou ignorar exceções verificadas
            System.err.println("Erro ao retornar ao menu: " + e.getMessage());
        }
    }

    private String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFC); // IDS01-J: normalização de strings antes da validação
    }
}
