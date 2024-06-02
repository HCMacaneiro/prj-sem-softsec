package View;

import Controller.MenuEmailController;
import Controller.MenuInicialController;
import Model.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class LerCaixaView {

    private final Scanner scanner;
    private MenuEmailController menuEmailController;

    public LerCaixaView(){this.scanner = new Scanner(System.in);}

    public void displayCaixaPostal(ArrayList<Message> caixa_postal, String email, int email_id){
        System.out.println("");
        System.out.println("");
        System.out.println("=====================");
        System.out.println("Carregando Caixa postal...");
        System.out.println("=====================");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Message m : caixa_postal){
            System.out.println("");
            System.out.println("");
            System.out.println("=====================");
            System.out.println("Remetente: " + m.getSender_id());
            System.out.println("Assunto: " + m.getSubject());
            System.out.println("Corpo: " + m.getBody());
            System.out.println("=====================");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        new MenuEmailController().handleMenu(email, email_id);
    }

}
