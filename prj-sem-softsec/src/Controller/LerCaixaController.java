package Controller;

import DAO.LerCaixaDAO;
import Model.Message;
import View.LerCaixaView;

import java.sql.SQLException;
import java.util.ArrayList;

public class LerCaixaController {

    private LerCaixaView view;
    private LerCaixaDAO lerCaixaDAO = LerCaixaDAO.getInstance(); // MSC07-J: Implementação do padrão Singleton
    private MenuEmailController menuEmailController;

    public LerCaixaController(){
        this.view = new LerCaixaView();
    }

    public void handleMenu(String email, int email_id){
        ArrayList<Message> caixa_postal = new ArrayList<>();
        try {
            caixa_postal = lerCaixaDAO.capturar(email_id);
        } catch (SQLException e) {
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            System.err.println("Erro ao capturar emails: " + e.getMessage());
        }
        view.displayCaixaPostal(caixa_postal, email, email_id);

        new MenuEmailController().handleMenu(email, email_id);
    }
}
