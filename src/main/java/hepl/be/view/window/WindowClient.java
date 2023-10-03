package hepl.be.view.window;

import hepl.be.controller.MainWindowController;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WindowClient extends JFrame {
    private JPanel centralwidget;
    private JButton pushButtonLogout;
    private JButton pushButtonLogin;
    private JLabel label_2;
    private JLabel label;
    private JTextField lineEditMotDePasse;
    private JTextField lineEditNom;
    private JCheckBox checkBoxNouveauClient;
    private JLabel label_3;
    private JPanel frame;
    private JLabel scrollArea;
    private JLabel label_4;
    private JTextField lineEditArticle;
    private JLabel label_5;
    private JTextField lineEditPrixUnitaire;
    private JLabel label_6;
    private JTextField lineEditStock;
    private JLabel label_7;
    private JButton pushButtonAcheter;
    private JButton pushButtonPrecedent;
    private JButton pushButtonSuivant;
    private JSpinner spinBoxQuantite;
    private JLabel label_8;
    private JPanel frame_2;
    private JTable tableWidgetPanier;
    private JLabel label_9;
    private JTextField lineEditTotal;
    private JButton pushButtonSupprimer;
    private JButton pushButtonViderPanier;
    private JButton pushButtonPayer;
    private JTextField lineEditPublicite;
    private JMenuBar menubar;

    public WindowClient() {
        setTitle("Le Maraicher en ligne");
        setSize(770, 618);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        centralwidget = new JPanel();
        centralwidget.setLayout(null);

        pushButtonLogout = new JButton("Logout");
        pushButtonLogout.setEnabled(false);
        pushButtonLogout.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        pushButtonLogout.setBackground(new Color(252, 175, 62));
        pushButtonLogout.setBounds(520, 10, 91, 25);

        pushButtonLogin = new JButton("Login");
        pushButtonLogin.setBounds(420, 10, 91, 25);
        pushButtonLogin.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        pushButtonLogin.setBackground(new Color(138, 226, 52));

        label_2 = new JLabel("Mot de passe:");
        label_2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_2.setBounds(180, 10, 131, 21);

        label = new JLabel("Nom:");
        label.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label.setBounds(8, 10, 64, 21);

        lineEditMotDePasse = new JTextField();
        lineEditMotDePasse.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lineEditMotDePasse.setHorizontalAlignment(JTextField.CENTER);
        lineEditMotDePasse.setBounds(298, 10, 113, 25);

        lineEditNom = new JTextField();
        lineEditNom.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lineEditNom.setHorizontalAlignment(JTextField.CENTER);
        lineEditNom.setBounds(58, 10, 113, 25);

        checkBoxNouveauClient = new JCheckBox("Nouveau client");
        checkBoxNouveauClient.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        checkBoxNouveauClient.setBounds(620, 10, 151, 23);

        label_3 = new JLabel("Magasin:");
        label_3.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_3.setBounds(10, 50, 81, 17);

        frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(10, 70, 751, 221);
        frame.setBorder(BorderFactory.createRaisedBevelBorder());

        scrollArea = new JLabel();
        scrollArea.setBounds(10, 10, 201, 201);




        label_4 = new JLabel("Article:");
        label_4.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_4.setBounds(230, 20, 61, 21);

        lineEditArticle = new JTextField();
        lineEditArticle.setEditable(false);
        lineEditArticle.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lineEditArticle.setHorizontalAlignment(JTextField.CENTER);
        lineEditArticle.setBounds(310, 20, 211, 25);

        label_5 = new JLabel("Prix à l'unité:");
        label_5.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_5.setBounds(230, 70, 121, 21);

        lineEditPrixUnitaire = new JTextField();
        lineEditPrixUnitaire.setEditable(false);
        lineEditPrixUnitaire.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lineEditPrixUnitaire.setHorizontalAlignment(JTextField.CENTER);
        lineEditPrixUnitaire.setBounds(360, 70, 161, 25);

        label_6 = new JLabel("Stock:");
        label_6.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_6.setBounds(230, 120, 64, 21);

        lineEditStock = new JTextField();
        lineEditStock.setEditable(false);
        lineEditStock.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lineEditStock.setHorizontalAlignment(JTextField.CENTER);
        lineEditStock.setBounds(360, 120, 161, 25);

        label_7 = new JLabel("Quantité souhaitée:");
        label_7.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_7.setBounds(230, 170, 181, 21);

        pushButtonAcheter = new JButton("Acheter");
        pushButtonAcheter.setEnabled(false);
        pushButtonAcheter.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        pushButtonAcheter.setBackground(Color.lightGray);
        pushButtonAcheter.setBounds(540, 170, 201, 25);

        pushButtonPrecedent = new JButton("<<<");
        pushButtonPrecedent.setEnabled(false);
        pushButtonPrecedent.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        pushButtonPrecedent.setBackground(new Color(182, 250, 217));
        pushButtonPrecedent.setBounds(540, 20, 91, 131);

        pushButtonSuivant = new JButton(">>>");
        pushButtonSuivant.setEnabled(false);
        pushButtonSuivant.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        pushButtonSuivant.setBackground(new Color(182, 250, 217));
        pushButtonSuivant.setBounds(650, 20, 91, 131);

        spinBoxQuantite = new JSpinner();
        spinBoxQuantite.setEnabled(false);
        spinBoxQuantite.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        spinBoxQuantite.setBounds(418, 170, 101, 26);

        label_8 = new JLabel("Panier:");
        label_8.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_8.setBounds(10, 350, 64, 17);

        frame_2 = new JPanel();
        frame_2.setLayout(null);
        frame_2.setBounds(10, 370, 751, 211);
        frame_2.setBorder(BorderFactory.createRaisedBevelBorder());


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Article");
        model.addColumn("Prix à l'unité");
        model.addColumn("Quantité");

        tableWidgetPanier = new JTable(model);
        tableWidgetPanier.setBounds(10, 10, 511, 151);

        label_9 = new JLabel("Total à payer:");
        label_9.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        label_9.setBounds(10, 170, 121, 21);

        lineEditTotal = new JTextField();
        lineEditTotal.setEditable(false);
        lineEditTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        lineEditTotal.setHorizontalAlignment(JTextField.CENTER);
        lineEditTotal.setBounds(140, 170, 131, 25);

        pushButtonSupprimer = new JButton("Supprimer article");
        pushButtonSupprimer.setEnabled(false);
        pushButtonSupprimer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        pushButtonSupprimer.setBackground(new Color(182, 250, 217));
        pushButtonSupprimer.setBounds(540, 10, 201, 25);

        pushButtonViderPanier = new JButton("Vider le panier");
        pushButtonViderPanier.setEnabled(false);
        pushButtonViderPanier.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        pushButtonViderPanier.setBackground(new Color(182, 250, 217));
        pushButtonViderPanier.setBounds(540, 50, 201, 25);

        pushButtonPayer = new JButton("Payer");
        pushButtonPayer.setEnabled(false);
        pushButtonPayer.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
        pushButtonPayer.setBackground(Color.lightGray);
        pushButtonPayer.setBounds(540, 130, 201, 25);

        lineEditPublicite = new JTextField();
        lineEditPublicite.setEditable(false);
        lineEditPublicite.setFont(new Font("Courier 10 Pitch", Font.BOLD, 18));
        lineEditPublicite.setHorizontalAlignment(JTextField.CENTER);
        lineEditPublicite.setBackground(Color.YELLOW);
        lineEditPublicite.setForeground(Color.red);
        lineEditPublicite.setBounds(10, 300, 751, 41);

        menubar = new JMenuBar();
        menubar.setBounds(0, 0, 770, 22);


        // Add components to centralwidget
        centralwidget.add(pushButtonLogout);
        centralwidget.add(pushButtonLogin);
        centralwidget.add(label_2);
        centralwidget.add(label);
        centralwidget.add(lineEditMotDePasse);
        centralwidget.add(lineEditNom);
        centralwidget.add(checkBoxNouveauClient);
        centralwidget.add(label_3);
        centralwidget.add(frame);
        centralwidget.add(label_8);
        centralwidget.add(frame_2);
        centralwidget.add(lineEditPublicite);

        // Add components to frame
        frame.add(scrollArea);
        frame.add(label_4);
        frame.add(lineEditArticle);
        frame.add(label_5);
        frame.add(lineEditPrixUnitaire);
        frame.add(label_6);
        frame.add(lineEditStock);
        frame.add(label_7);
        frame.add(pushButtonAcheter);
        frame.add(pushButtonPrecedent);
        frame.add(pushButtonSuivant);
        frame.add(spinBoxQuantite);

        // Add components to frame_2
        frame_2.add(tableWidgetPanier);
        frame_2.add(label_9);
        frame_2.add(lineEditTotal);
        frame_2.add(pushButtonSupprimer);
        frame_2.add(pushButtonViderPanier);
        frame_2.add(pushButtonPayer);

        // Add centralwidget to the frame
        setContentPane(centralwidget);
        setVisible(true);
    }


    public void setController(MainWindowController mainWindowController)
    {
        pushButtonLogin.addActionListener(mainWindowController);
        pushButtonLogout.addActionListener(mainWindowController);
        pushButtonAcheter.addActionListener(mainWindowController);
        pushButtonPrecedent.addActionListener(mainWindowController);
        pushButtonSuivant.addActionListener(mainWindowController);
        pushButtonSupprimer.addActionListener(mainWindowController);
        pushButtonViderPanier.addActionListener(mainWindowController);
        pushButtonPayer.addActionListener(mainWindowController);
    }

    public void setNom(String nom)
    {
        lineEditNom.setText(nom);
    }
    public String getNom()
    {
        return lineEditNom.getText();
    }
    public void setMotDePasse(String motDePasse)
    {
        lineEditMotDePasse.setText(motDePasse);
    }
    public String getMotDePasse()
    {
        return lineEditMotDePasse.getText();
    }
    public void setPrix(float prix)
    {
        if(prix >= 0)
            lineEditPrixUnitaire.setText(String.valueOf(prix));
        else
            lineEditPrixUnitaire.setText("");
    }
    public void setStock(int stock)
    {
        if(stock >= 0)
            lineEditStock.setText(String.valueOf(stock));
        else
            lineEditStock.setText("");
    }
    public void setPublicite(String text){
        lineEditPublicite.setText(text);
    }
    public int isNouveauClientChecked()
    {
        if(checkBoxNouveauClient.isSelected())
            return 1;
        else
            return 0;
    }
    public void setArticle(String article, float prix, int stock, String image) {
        lineEditArticle.setText(article);
        setPrix(prix);
        setStock(stock);


        // Load the image from the specified path
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + image);

        // Create a JLabel to display the image
        scrollArea.setIcon(imageIcon);
    }
    public void setQuantite(int quantite)
    {
        spinBoxQuantite.setValue(quantite);
    }
    public int getQuantité()
    {
        return (int) spinBoxQuantite.getValue();
    }

    public void setTotal(float total)
    {
        if(total >= 0)
            lineEditTotal.setText(String.format("%.2f", total)+"€");
        else
            lineEditTotal.setText("");
    }

    public void LoginOK()
    {
        pushButtonLogin.setEnabled(false);
        pushButtonLogout.setEnabled(true);
        lineEditNom.setEnabled(false);
        lineEditMotDePasse.setEnabled(false);
        checkBoxNouveauClient.setEnabled(false);

        spinBoxQuantite.setEnabled(true);
        pushButtonPrecedent.setEnabled(true);
        pushButtonSuivant.setEnabled(true);
        pushButtonAcheter.setEnabled(true);
        pushButtonSupprimer.setEnabled(true);
        pushButtonViderPanier.setEnabled(true);
        pushButtonPayer.setEnabled(true);
    }

    public void LogoutOK()
    {

        pushButtonLogin.setEnabled(true);
        pushButtonLogout.setEnabled(false);
        lineEditNom.setEnabled(true);
        lineEditMotDePasse.setEnabled(true);
        checkBoxNouveauClient.setEnabled(true);

        spinBoxQuantite.setEnabled(false);
        pushButtonPrecedent.setEnabled(false);
        pushButtonSuivant.setEnabled(false);
        pushButtonAcheter.setEnabled(false);
        pushButtonSupprimer.setEnabled(false);
        pushButtonViderPanier.setEnabled(false);
        pushButtonPayer.setEnabled(false);

        setArticle("", -1, -1, "");

        setMotDePasse("");
        setNom("");

        setQuantite(0);

        if(checkBoxNouveauClient.isSelected())
            checkBoxNouveauClient.setSelected(false);

        videTablePanier();
        setTotal(-1);
    }

    public void ajouteArticleTablePanier(String article, float prix, int quantite) {

        DefaultTableModel model = (DefaultTableModel) tableWidgetPanier.getModel();
        model.addRow(new Object[]{article, String.format("%.2f", prix)+"€", quantite});
    }

    public void videTablePanier() {
        DefaultTableModel model = (DefaultTableModel) tableWidgetPanier.getModel();
        model.setRowCount(0);
    }

    public int getIndiceArticleSelectionne()
    {
        return tableWidgetPanier.getSelectedRow();
    }

    public void dialogueMessage(String titre, String message) {
        JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
    }

    public void dialogueErreur(String titre, String message) {
        JOptionPane.showMessageDialog(null, message, titre, JOptionPane.ERROR_MESSAGE);
    }


}
