package Controller;

import DAO.CapturaID;
import Model.Authenticate;
import View.AuthenticateView;
import Controller.MenuEmailController;

public class AuthenticateController { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private AuthenticateView view;
    private Authenticate authenticate;
    private MenuEmailController menuEmailController;
    private int email_id;

    public AuthenticateController() {
        this.view = new AuthenticateView();
    }

    public void handleAuthentication() {
        view.displayLoginCredentials();
        String email = view.getEmail();
        view.displayPasswordPrompt();
        String password = view.getPassword();
        this.authenticate = new Authenticate(email, password);

        boolean success = authenticate.authenticate();
        view.displayAuthenticationResult(success);

        // se o usuário for autenticado, entra-se no email
        if (success == true){
            email_id = new CapturaID().inserir(email);
            menuEmailController = new MenuEmailController();
            menuEmailController.handleMenu(email, email_id);
        }
    }
}

