package Controller;

import Model.Authenticate;
import View.AuthenticateView;
import Controller.MenuEmailController;

public class AuthenticateController {

    private AuthenticateView view;
    private Authenticate authenticate;
    private MenuEmailController menuEmailController;

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
            menuEmailController = new MenuEmailController();
            menuEmailController.handleMenu(email);
        }
    }
}

