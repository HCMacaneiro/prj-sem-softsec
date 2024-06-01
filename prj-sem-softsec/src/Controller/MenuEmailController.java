package Controller;

import View.MenuEmailView;

public class MenuEmailController {

    private MenuEmailView view;
    private EnviarEmailController enviarEmailController;
    private LerCaixaController lerCaixaController;

    public MenuEmailController(){
        this.view = new MenuEmailView();
    }

    public void handleMenu(String email) {
        view.displayMenu(email);
        int choice = view.getUserInput();

        switch (choice) {
            case 1:
                enviarEmailController = new EnviarEmailController();
                enviarEmailController.handleMenu();
            case 2:
                lerCaixaController = new LerCaixaController();
                lerCaixaController.handleMenu();
            case 3:
                System.exit(0);
            default:
                System.out.printf("Escolha inválida. Por favor, tente novamente.");
                handleMenu(email);
        }
    }
}
