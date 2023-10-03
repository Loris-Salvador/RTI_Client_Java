package hepl.be;

import hepl.be.controller.MainWindowController;
import hepl.be.view.window.WindowClient;

public class Main {
    public static void main(String[] args) {

        System.out.println("WOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO2222222222222222222222éé");
        WindowClient mainWindow = new WindowClient();
        MainWindowController mainWindowController = new MainWindowController(mainWindow);
        mainWindow.setController(mainWindowController);

    }
}