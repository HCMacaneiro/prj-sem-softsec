package Controller;

import DAO.CapturaRecipients;
import View.EnviarEmailView;

import java.util.ArrayList;

public class EnviarEmailController {

    private EnviarEmailView view;
    private CapturaRecipients capturaRecipients = new CapturaRecipients();

    public EnviarEmailController(){
        this.view = new EnviarEmailView();
    }

    public void handleMenu(int email_id){
        ArrayList<Integer> id_array = capturaRecipients.getId();
        ArrayList<String> email_array = capturaRecipients.getEmail();

        view.displayEmailRecipient(id_array, email_array);
        int recipient = view.getRecipient();

        view.displayEmailSubject();
        String subject = view.getSubject();

        view.displayEmailBody();
        String body = view.getBody();
    }
}
