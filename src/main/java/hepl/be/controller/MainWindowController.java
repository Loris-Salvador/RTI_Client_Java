package hepl.be.controller;


import hepl.be.controller.LibSocket.LibSocket;
import hepl.be.view.window.WindowClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class MainWindowController implements ActionListener {

    private WindowClient mainWindow;
    private Socket sSocket;

    private int CurrentIdArticle = 0;

    public MainWindowController(WindowClient mainWindow)
    {
        this.mainWindow = mainWindow;
        mainWindow.setPublicite("Loris le BOT");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        boolean boucle = true;
        if(source.getText().equals("Login"))
        {
            // Création de la socket et connexion sur le serveur
            try {
                sSocket = new Socket("172.20.10.3", 50000);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            // Envoi de la requête
            LibSocket.send(sSocket, "LOGIN#" + mainWindow.getNom() + "#" + mainWindow.getMotDePasse() + "#" + mainWindow.isNouveauClientChecked());

            // Réponse du Serveur
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // Code à exécuter après 2 secondes
                    String reponse = LibSocket.receive(sSocket);

                    String[] mots = reponse.split("#");

                    if (mots[1].equals("OK")) {
                        Consult(CurrentIdArticle);
                        mainWindow.LoginOK();
                    }

                    boolean boucle = true;
                    while (boucle) {
                        boucle = false;
                        if (mots[0].equals("LOGIN")) {
                            if (mots[1].equals("OK")) {
                                mainWindow.LoginOK();
                                mainWindow.dialogueMessage("LOGIN", mots[2]);
                            } else if (mots[1].equals("BAD")) {
                                mainWindow.dialogueErreur("LOGIN", mots[2]);
                                return;
                            } else if (mots[1].equals("FILE")) {
                                mainWindow.dialogueMessage("LOGIN", "Vous avez été placé dans la file d'attente. Veuillez patienter...");
                                reponse = LibSocket.receive(sSocket);
                                mots = reponse.split("#");

                                boucle = true;
                            } else {
                                mainWindow.dialogueErreur(mots[0], mots[2]);
                            }
                        } else {
                            mainWindow.dialogueErreur(mots[0], mots[2]);
                        }
                    }
                }
            }, 2000);


        }
        else if(source.getText().equals("Logout"))
        {
            //Envoie de la requete
            LibSocket.send(sSocket,"LOGOUT");

            //Réponse
            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");

            //Fermeture de la socket
            try {
                sSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            if(mots[1].equals("OK"))
            {
                mainWindow.LogoutOK();
            }
        }
        else if(source.getText().equals(">>>"))
        {
            CurrentIdArticle = (CurrentIdArticle+1)%21;
            Consult(CurrentIdArticle);
        }
        else if(source.getText().equals("<<<"))
        {
            CurrentIdArticle = (CurrentIdArticle+20)%21;
            Consult(CurrentIdArticle);
        }
        else if(source.getText().equals("Acheter"))
        {
            if(mainWindow.getQuantité() == 0)
                return;

            LibSocket.send(sSocket,"ACHAT#"+(CurrentIdArticle+1)+"#"+mainWindow.getQuantité());

            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");

            if(mots[0].equals("ACHAT"))
            {
                if(mots[1].equals("0"))
                {
                    mainWindow.dialogueErreur(mots[0],mots[3]);
                }
                else if(!mots[1].equals("-1"))
                {
                    if(!mots[2].equals("0"))
                    {
                        mainWindow.ajouteArticleTablePanier(mots[3],Float.parseFloat(mots[4]),Integer.parseInt(mots[2]));

                        Consult(CurrentIdArticle);
                    }
                    else
                        mainWindow.dialogueErreur(mots[0],"Pas assez de stock");
                }
                else
                    mainWindow.dialogueErreur(mots[0],"Not Found");
            }
            else
                mainWindow.dialogueErreur(mots[0],"Error");
            Actualiser_Panier();
        }
        else if(source.getText().equals("Supprimer article"))
        {
            if(mainWindow.getIndiceArticleSelectionne() == -1)
                return;

            LibSocket.send(sSocket,"CANCEL#"+mainWindow.getIndiceArticleSelectionne());

            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");

            if(mots[1].equals("OK"))
            {
                Actualiser_Panier();
                Consult(CurrentIdArticle);
            }
            else
                mainWindow.dialogueErreur(mots[0],"Error");
        }
        else if(source.getText().equals("Vider le panier"))
        {
            LibSocket.send(sSocket, "CANCEL ALL#" + mainWindow.getIndiceArticleSelectionne());

            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");

            if(!mots[1].equals("OK"))
            {
                mainWindow.dialogueErreur(mots[0],"Error");
                return;
            }

            Actualiser_Panier();
            Consult(CurrentIdArticle);
        }
        else if(source.getText().equals("Payer"))
        {
            LibSocket.send(sSocket, "CONFIRMER#" + mainWindow.getNom());

            String reponse = LibSocket.receive(sSocket);

            String[] mots = reponse.split("#");

            if(mots[1].equals("OK"))
            {
                Actualiser_Panier();
                mainWindow.setTotal(-1);
                mainWindow.dialogueMessage("SUCCESS", "Achat reussi !");
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
            if (!mots[1].equals("-1"))
            {
                mainWindow.setArticle(mots[2], Float.parseFloat(mots[5]), Integer.parseInt(mots[3]), mots[4]);
            }
            else
                mainWindow.dialogueErreur(mots[0],mots[2]);
        }
        else
            mainWindow.dialogueErreur(mots[0],mots[2]);
    }

    private void Actualiser_Panier()
    {
        mainWindow.videTablePanier();

        LibSocket.send(sSocket,"CADDIE");

        String reponse = LibSocket.receive(sSocket);

        String[] mots = reponse.split("#");

        int count = Integer.parseInt(mots[2]);
        float total=0;
        for(int i=0;i<count;i++)
        {
            total = total + Float.parseFloat(mots[i*5+7])*Integer.parseInt(mots[i*5+5]);
            System.out.println(reponse);
            mainWindow.ajouteArticleTablePanier(mots[i*5+4], Float.parseFloat(mots[i*5+7]), Integer.parseInt(mots[i*5+5]));
        }

        mainWindow.setTotal(total);

    }
}