package hepl.be;

import hepl.be.controller.MainWindowController;
import hepl.be.view.window.WindowClient;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");

        WindowClient mainWindow = new WindowClient();
        MainWindowController mainWindowController = new MainWindowController(mainWindow);
        mainWindow.setController(mainWindowController);

    }
}