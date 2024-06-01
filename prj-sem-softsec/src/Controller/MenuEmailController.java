package Controller;

import View.MenuEmailView;

public class MenuEmailController {

    private MenuEmailView view;

    public MenuEmailController(){
        this.view = new MenuEmailView();
    }

    public void handleMenu(String email) {
        view.displayMenu(email);
    }

}
