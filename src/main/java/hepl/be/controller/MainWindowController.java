package hepl.be.controller;


import hepl.be.controller.LibSocket.LibSocket;
import hepl.be.view.window.WindowClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class MainWindowController implements ActionListener {

    private WindowClient mainWindow;
    private Socket sSocket;

    public MainWindowController(WindowClient mainWindow)
    {
        this.mainWindow = mainWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source.getText().equals("Login"))
        {
            // Création de la socket et connexion sur le serveur
            try {
                sSocket = new Socket("192.168.203.128",1024);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //Envoi de la requete
            LibSocket.send(sSocket,"LOGIN#"+ mainWindow.getNom()+"#"+ mainWindow.getMotDePasse()+"#" + mainWindow.isNouveauClientSelected());


            //Réponse du Serveur
            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");

            if(mots[1].equals("OK")) {
                Consult(4);
                mainWindow.LoginOK();
            }

        }
        else if(source.getText().equals("Logout"))
        {
            //Envoie de la requete
            LibSocket.send(sSocket,"LOGOUT");

            //Réponse
            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");


            if(mots[1].equals("OK"))
            {
                mainWindow.LogoutOK();
            }
            //Fermeture de la socket
            try {
                sSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void Consult(int id)
    {
        id++;
        LibSocket.send(sSocket,"CONSULT#"+id);

        String reponse = LibSocket.receive(sSocket);

        String[] mots = reponse.split("#");

        if (mots[0].equals("CONSULT"))
        {
            if (mots[1] != "-1")
            {
                mainWindow.setArticle(mots[2], Float.parseFloat(mots[5]), Integer.parseInt(mots[3]), mots[4]);
            }
            //else
                //dialogueErreur(ptr,message);
        }
        //else
            //dialogueErreur(ptr,message);
    }

//    private void setArticle(String intitule, float prix, int stock, String image)
//    {
//        //mainWindow.setImageArticle(image);
//    }
}
