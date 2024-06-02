package Controller;

import View.EnviarEmailView;

public class EnviarEmailController {

    private EnviarEmailView view;

    public EnviarEmailController(){
        this.view = new EnviarEmailView();
    }

    public void handleMenu(int email_id){
        view.displayEmailSubject();
        String subject = view.getSubject();

        view.displayEmailBody();
        String body = view.getBody();

        view.displayEmailRecipient();
        int recipient = view.getRecipient();
    }
}
