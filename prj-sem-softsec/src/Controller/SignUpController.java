package Controller;

import DAO.SignUpDAO;
import Model.SignUp;
import Model.Usuario;
import View.SignUpView;

public class SignUpController {

    private SignUpView view;
    private SignUp signUp;
    private Usuario usuario;
    private SignUpDAO signUpDAO;

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
            // cria objeto de usuário para inserir no B.D
            usuario = new Usuario(email);
            signUpDAO = new SignUpDAO();
            try {
                signUpDAO.inserir(usuario);
                new MenuInicialController().handleMenu();
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            }
        }else {
            view.displaySignUpResult(false);
        }
    }
}

