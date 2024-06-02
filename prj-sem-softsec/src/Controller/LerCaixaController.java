package Controller;

import DAO.LerCaixaDAO;
import Model.Message;
import View.LerCaixaView;

import java.util.ArrayList;

public class LerCaixaController {

    private LerCaixaView view;
    private LerCaixaDAO lerCaixaDAO = new LerCaixaDAO();
    private MenuEmailController menuEmailController;

    public LerCaixaController(){
        this.view = new LerCaixaView();
    }

    public void handleMenu(String email, int email_id){
        ArrayList<Message> caixa_postal = lerCaixaDAO.capturar(email_id);
        view.displayCaixaPostal(caixa_postal, email, email_id);

        new MenuEmailController().handleMenu(email, email_id);
    }

}
