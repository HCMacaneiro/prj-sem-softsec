package Controller;

import View.MenuEmailView;

public class MenuEmailController { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private final MenuEmailView view;
    private final LerCaixaController lerCaixaController;

    public MenuEmailController(){
        this.view = new MenuEmailView();
        this.lerCaixaController = new LerCaixaController();
    }

    public void handleMenu(String email, int email_id) {
        view.displayMenu(email);
        int choice = view.getUserInput();

        switch (choice) {
            case 1:
                EnviarEmailController enviarEmailController = new EnviarEmailController();
                enviarEmailController.handleMenu(email, email_id);
            case 2:
                lerCaixaController.handleMenu(email, email_id);
            case 3:
                System.exit(0);
            default:
                System.out.printf("Escolha inválida. Por favor, tente novamente.");
                handleMenu(email, email_id);
        }
    }
}
