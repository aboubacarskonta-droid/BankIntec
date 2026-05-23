package view;

import Entites.Compte;
import javax.swing.*;
import java.awt.*;

public class AgenceForm extends JPanel {
    // Déclaration et initialisation directe des composants du formulaire
    private final JTextField txtNumeroAgence = new JTextField(20);
    private final JTextField txtNom = new JTextField(20);
    private final JTextField txtAdrresse = new JTextField(20);
    private final JTextField txtContact = new JTextField(20);
    private final JTextField txtEmail = new JTextField(20);
    private final JTextField txtNBpersonne = new JTextField(20);

    private final JButton btnListe = new JButton("Liste");
    private final JButton btnEnregistre = new JButton("Enregistrer");
    private final JButton btnSupprimer = new JButton("Supprimer");

    // Constructeur : Configuration de l'interface
    public AgenceForm() {
        // 1. Configuration de l'agencement principal du JPanel
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // AJOUT DU TITRE EN HAUT
        JLabel lblTitre = new JLabel("Formulaire d'Agence", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 20)); // Écrit en gras, taille 20
        lblTitre.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // Espacement sous le titre
        add(lblTitre, BorderLayout.NORTH);

        // 2. Création du panneau de formulaire (Grille simple 6 lignes, 2 colonnes)
        JPanel panelFormulaire = new JPanel(new GridLayout(6, 2, 10, 10));

        panelFormulaire.add(new JLabel("Numéro Agence :"));
        panelFormulaire.add(txtNumeroAgence);

        panelFormulaire.add(new JLabel("Nom :"));
        panelFormulaire.add(txtNom);

        panelFormulaire.add(new JLabel("Adresse :"));
        panelFormulaire.add(txtAdrresse);

        panelFormulaire.add(new JLabel("Contact :"));
        panelFormulaire.add(txtContact);

        panelFormulaire.add(new JLabel("Email :"));
        panelFormulaire.add(txtEmail);

        panelFormulaire.add(new JLabel("Nb Personnes :"));
        panelFormulaire.add(txtNBpersonne);

        // 3. Création du panneau pour les boutons d'action
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        // Couleurs de style sur les boutons
        btnEnregistre.setBackground(new Color(46, 204, 113));
        btnEnregistre.setForeground(Color.WHITE);
        btnSupprimer.setBackground(new Color(231, 76, 60));
        btnSupprimer.setForeground(Color.WHITE);

        panelBoutons.add(btnListe);
        panelBoutons.add(btnSupprimer);
        panelBoutons.add(btnEnregistre);

        // Intégration des sous-panneaux au panneau principal
        add(panelFormulaire, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

        // 4. Gestion des clics avec la syntaxe courte des Lambdas (->)
        btnEnregistre.addActionListener(e -> {
            if (txtNumeroAgence.getText().trim().isEmpty() || txtNom.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Erreur : Le numéro et le nom sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Agence '" + txtNom.getText() + "' enregistrée !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                viderChamps();
            }
        });

        // ACTION DU BOUTON LISTE : Ouvre la fenêtre avec le tableau de données
        btnListe.addActionListener(e -> {
            // Simulation de données (Normalement issues de votre base de données)
            String[][] donnees = {
                    {"001", "Agence Centre", "Rue de la Gare", "+223 20 00 00 00", "centre@banque.com", "12"},
                    {"002", "Agence Nord", "Avenue Al Qods", "+223 20 11 11 11", "nord@banque.com", "8"},
                    {"003", "Agence Sud", "Quartier du Fleuve", "+223 20 22 22 22", "sud@banque.com", "15"}
            };

            // Titres des colonnes
            String[] colonnes = {"N° Agence", "Nom", "Adresse", "Contact", "Email", "Nb Personnes"};

            // Appel de la méthode pour ouvrir la liste
            afficherFenetreListe(donnees, colonnes);
        });

        btnSupprimer.addActionListener(e -> {
            String numero = txtNumeroAgence.getText().trim();
            if (numero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez indiquer le numéro de l'agence à supprimer.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int choix = JOptionPane.showConfirmDialog(this, "Supprimer définitivement l'agence N° " + numero + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Agence supprimée.", "Statut", JOptionPane.INFORMATION_MESSAGE);
                viderChamps();
            }
        });
    }

    // Méthode qui génère et affiche la fenêtre de la liste
    private void afficherFenetreListe(String[][] donnees, String[] colonnes) {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog fenetreListe = new JDialog(parentWindow, "Liste des Agences", Dialog.ModalityType.APPLICATION_MODAL);
        fenetreListe.setSize(750, 300);
        fenetreListe.setLocationRelativeTo(this);
        fenetreListe.setLayout(new BorderLayout(10, 10));

        JTable tableau = new JTable(donnees, colonnes);
        tableau.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tableau);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        fenetreListe.add(scrollPane, BorderLayout.CENTER);

        JButton btnFermer = new JButton("Fermer l'aperçu");
        btnFermer.addActionListener(ev -> fenetreListe.dispose());

        JPanel panelBas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBas.add(btnFermer);
        fenetreListe.add(panelBas, BorderLayout.SOUTH);

        fenetreListe.setVisible(true);
    }

    // Méthode pour nettoyer le formulaire
    private void viderChamps() {
        txtNumeroAgence.setText("");
        txtNom.setText("");
        txtAdrresse.setText("");
        txtContact.setText("");
        txtEmail.setText("");
        txtNBpersonne.setText("");
    }

    // Code de test (Main)
}