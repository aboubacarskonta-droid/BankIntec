package view;

import Entites.Compte;
import javax.swing.*;
import java.util.Date;

public class compteForm extends JFrame {

    // Déclaration de tous les composants graphiques
    private JTextField txtCode;
    private JTextField txtSolde;
    private JTextField txtMontant;
    private JButton btnCreer;
    private JButton btnVerser;
    private JButton btnRetirer;

    // Instance du modèle métier
    private Compte monCompte;

    // ===== CONSTRUCTEUR =====
    public compteForm() {
        // 1. Configuration essentielle de la fenêtre
        setTitle("Gestion de Compte Bancaire");
        setSize(420, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centre la fenêtre à l'écran
        setLayout(null);              // Positionnement manuel absolu

        // 2. Initialisation manuelle de TOUS les composants (Plus aucun risque de null !)
        txtCode = new JTextField();
        txtSolde = new JTextField();
        txtMontant = new JTextField();

        btnCreer = new JButton("Créer");
        btnVerser = new JButton("Verser");
        btnRetirer = new JButton("Retirer");

        // Sécurité : Le champ du code est verrouillé dès le départ
        txtCode.setEditable(false);

        // 3. Placement des éléments sur la grille (X, Y, Largeur, Hauteur)
        addField("Code Compte :", txtCode, 30);
        addField("Solde Actuel :", txtSolde, 70);
        addField("Montant Opération :", txtMontant, 110);

        // Positionnement des boutons
        btnCreer.setBounds(30, 180, 100, 30);
        btnVerser.setBounds(150, 180, 100, 30);
        btnRetirer.setBounds(270, 180, 100, 30);

        // Ajout des boutons à la fenêtre
        add(btnCreer);
        add(btnVerser);
        add(btnRetirer);

        // ==========================================================
        // ACTION : CRÉER LE COMPTE
        // ==========================================================
        btnCreer.addActionListener(e -> {
            try {
                float soldeInitial = Float.parseFloat(txtSolde.getText().trim());

                // Constructeur utilisé : Compte(code, solde, nbComptes, created, update)
                monCompte = new Compte(101, soldeInitial, 0, new Date(), new Date());

                // Affichage du code généré dans l'interface
                txtCode.setText(String.valueOf(monCompte.code));
                JOptionPane.showMessageDialog(this, "Compte n°" + monCompte.code + " créé avec succès !");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erreur : Saisissez un solde initial valide (ex: 1000).");
            }
        });

        // ==========================================================
        // ACTION : VERSER
        // ==========================================================
        btnVerser.addActionListener(e -> {
            if (verifierCompteExiste()) {
                try {
                    float mt = Float.parseFloat(txtMontant.getText().trim());
                    monCompte.verser(mt); // Appel de ta méthode dans Compte
                    actualiserAffichage();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur : Montant de versement invalide.");
                }
            }
        });

        // ==========================================================
        // ACTION : RETIRER
        // ==========================================================
        btnRetirer.addActionListener(e -> {
            if (verifierCompteExiste()) {
                try {
                    float mt = Float.parseFloat(txtMontant.getText().trim());
                    monCompte.retirer(mt); // Appel de ta méthode dans Compte
                    actualiserAffichage();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur : Montant de retrait invalide.");
                }
            }
        });
    }

    // ===== MÉTHODE POUR AJOUTER UN LABEL + CHAMP TEXTE =====
    private void addField(String labelText, JTextField field, int y) {
        JLabel lbl = new JLabel(labelText);
        lbl.setBounds(30, y, 130, 25);
        add(lbl);

        field.setBounds(170, y, 200, 25);
        add(field);
    }

    // ===== VÉRIFICATION DE SÉCURITÉ =====
    private boolean verifierCompteExiste() {
        if (monCompte == null) {
            JOptionPane.showMessageDialog(this, "Veuillez d'abord créer un compte avant toute opération.");
            return false;
        }
        return true;
    }

    // ===== MISE À JOUR DE L'INTERFACE =====
    private void actualiserAffichage() {
        txtSolde.setText(String.valueOf(monCompte.solde));
        txtMontant.setText(""); // On nettoie le champ de saisie
        System.out.println("Console Debug : " + monCompte.toString());
    }

    // ===== POINT D'ENTRÉE DU PROGRAMME =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new compteForm().setVisible(true);
        });
    }
}