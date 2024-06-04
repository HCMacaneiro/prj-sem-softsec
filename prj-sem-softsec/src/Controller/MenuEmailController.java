package Controller;

import View.MenuEmailView;
import java.util.NoSuchElementException;

public class MenuEmailController {

    private final MenuEmailView view;
    private final LerCaixaController lerCaixaController;

    public MenuEmailController() {
        this.view = new MenuEmailView();
        this.lerCaixaController = new LerCaixaController();
    }

    public void handleMenu(String email, int email_id) {
        view.displayMenu(email);
        int choice = -1;

        // captura a escolha do usuário, e se for inválida, limpa o buffer do scanner para evitar loop
        try {
            choice = view.getUserInput();
        } catch (NoSuchElementException e) {
            System.err.println("Entrada inválida: insira um número válido. Reiniciando o Menu...");
            view.limpaBufferScanner();
            handleMenu(email, email_id);
            return;
        }

        // menu de fato
        switch (choice) {
            case 1:
                EnviarEmailController enviarEmailController = new EnviarEmailController();
                enviarEmailController.handleMenu(email, email_id);
                break;
            case 2:
                lerCaixaController.handleMenu(email, email_id);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.err.println("Entrada inválida: insira um número válido. Reiniciando o Menu...");
                handleMenu(email, email_id);
                break;
        }
    }
}
