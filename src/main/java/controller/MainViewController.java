package controller;

import Service.UserInterfaceService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Bill on 23.07.2019.
 */
public class MainViewController implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println();
            UserInterfaceService userInterface = new UserInterfaceService();
            userInterface.showInterface();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
