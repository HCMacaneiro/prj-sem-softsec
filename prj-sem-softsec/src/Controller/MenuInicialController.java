package Controller;

import View.MenuInicialView;

public class MenuInicialController { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private MenuInicialView view;

    public MenuInicialController() {
        this.view = new MenuInicialView();
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
