package Controller;

import Model.SignUp;
import View.SignUpView;

public class SignUpController {

    private SignUpView view;
    private SignUp signUp;

    public SignUpController() {
        this.view = new SignUpView();
    }

    public void handleSignUp() {
        view.displaySignUp();
        String email = view.getEmail();
        view.displayPasswordPrompt();
        String password = view.getPassword();
        this.signUp = new SignUp(email, password);
        boolean success = signUp.signUp();
        if (success) {
            view.displaySignUpResult(true);
            new MenuInicialController().handleMenu();
        } else {
            view.displaySignUpResult(false);
        }
    }
}

