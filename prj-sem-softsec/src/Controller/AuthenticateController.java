package Controller;

import Model.Authenticate;
import View.AuthenticateView;

public class AuthenticateController {

    private AuthenticateView view;
    private Authenticate authenticate;

    public AuthenticateController() {
        this.view = new AuthenticateView();
        String email = view.getEmail();
        String password = view.getPassword();
        this.authenticate = new Authenticate(email, password);
    }

    public void handleAuthentication() {
        view.displayLoginCredentials();
        String email = view.getEmail();
        view.displayPasswordPrompt();
        String password = view.getPassword();

        boolean success = authenticate.authenticate();
        view.displayAuthenticationResult(success);
    }
}

