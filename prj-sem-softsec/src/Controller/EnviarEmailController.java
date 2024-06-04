package Controller;

import DAO.CapturaRecipients;
import DAO.EnviarEmailDAO;
import Model.Message;
import View.EnviarEmailView;

import java.sql.SQLException;
import java.util.ArrayList;

public class EnviarEmailController {

    private EnviarEmailView view;
    private CapturaRecipients capturaRecipients = new CapturaRecipients();
    private Message message;
    private EnviarEmailDAO enviarEmailDAO = new EnviarEmailDAO();
    private MenuEmailController menuEmailController = new MenuEmailController();

    public EnviarEmailController(){
        this.view = new EnviarEmailView();
    }

    public void handleMenu(String email, int email_id){
        ArrayList<Integer> id_array = new ArrayList<>();
        ArrayList<String> email_array = new ArrayList<>();
        try {
            id_array = capturaRecipients.getId();
            email_array = capturaRecipients.getEmail();
        } catch (SQLException e) {
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            System.err.println("Erro ao capturar destinatários: " + e.getMessage());
        }

        view.displayEmailRecipient(id_array, email_array);
        int recipient = view.getRecipient(email, email_id);

        view.displayEmailSubject();
        String subject = view.getSubject();

        view.displayEmailBody();
        String body = view.getBody();

        message = new Message(email_id, recipient, subject, body);

        try {
            enviarEmailDAO.inserir(message);
        } catch (SQLException e) {
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            System.err.println("Erro ao enviar email: " + e.getMessage());
        }

        view.displayEmailEnviado();

        menuEmailController.handleMenu(email, email_id);
    }
}
