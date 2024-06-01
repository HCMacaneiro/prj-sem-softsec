package Controller;

import View.MenuInicialView;

public class MenuInicialController {

    private MenuInicialView view;

    public MenuInicialController(MenuInicialView view) {
        this.view = view;
    }

    public void handleMenu() {
        view.displayMenu();
        int choice = view.getUserInput();

        switch (choice) {
            case 1:
                new AuthenticateController().handleAuthentication();
                break;
            case 2:
                new SignUpController().handleSignUp();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Escolha inválida. Por favor, tente novamente.");
                handleMenu();
        }
    }
}
