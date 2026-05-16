package view;

import Entites.Personne;
import javax.swing.*;

public class PersonneForm extends JFrame {

    // Attributs (champs du formulaire)
    private JTextField id;
    private JTextField nom;
    private JTextField prenom;
    private JTextField age;
    private JTextField adresse;
    private JTextField phone;
    private JTextField dateNaiss;
    private JTextField createDate;
    private JTextField update;
    private JButton valider;

    // Instance pour stocker la personne créée
    private Personne laPersonne;

    // ===== CONSTRUCTEUR =====
    public PersonneForm() {

        setTitle("Formulaire Personne");
        setSize(420, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Plus propre si tu ouvres plusieurs fenêtres
        setLocationRelativeTo(null); // Centre la fenêtre sur ton écran
        setLayout(null);

        // Création des champs
        id = new JTextField();
        nom = new JTextField();
        prenom = new JTextField();
        age = new JTextField();
        adresse = new JTextField();
        phone = new JTextField();
        dateNaiss = new JTextField();
        createDate = new JTextField();
        update = new JTextField();
        valider = new JButton("Valider");

        // Ajout des champs dans la fenêtre
        addField("ID", id, 20);
        addField("Nom", nom, 60);
        addField("Prénom", prenom, 100);
        addField("Age", age, 140);
        addField("Adresse", adresse, 180);
        addField("Téléphone", phone, 220);
        addField("Date naissance", dateNaiss, 260);
        addField("Date création", createDate, 300);
        addField("Date update", update, 340);

        // Bouton Valider
        valider.setBounds(140, 400, 120, 30);
        add(valider);

        // ==========================================
        // ACTION : CLIC SUR LE BOUTON VALIDER
        // ==========================================
        valider.addActionListener(e -> {
            try {
                // Récupération des données basiques
                String txtNom = nom.getText().trim();
                String txtPrenom = prenom.getText().trim();

                if (txtNom.isEmpty() || txtPrenom.isEmpty() || age.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir au moins le Nom, le Prénom et l'Âge.");
                    return;
                }

                int numAge = Integer.parseInt(age.getText().trim());

                // Utilisation de ton constructeur à 3 arguments !
                laPersonne = new Personne(txtNom, txtPrenom, numAge);

                // Message de succès et affichage console via le toString() de ton entité
                JOptionPane.showMessageDialog(this, "Personne créée avec succès !\n" + laPersonne.toString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "L'âge doit être un nombre entier valide.");
            }
        });
    }

    // ===== MÉTHODE POUR AJOUTER UN LABEL + CHAMP =====
    private void addField(String label, JTextField field, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(20, y, 130, 25);
        add(lbl);

        field.setBounds(160, y, 200, 25);
        add(field);
    }

    // ===== GETTERS POUR RÉCUPÉRER LES VALEURS =====
    public String getIdValue() { return id.getText(); }
    public String getNomValue() { return nom.getText(); }
    public String getPrenomValue() { return prenom.getText(); }
    public int getAgeValue() { return Integer.parseInt(age.getText()); }
    public String getAdresseValue() { return adresse.getText(); }
    public String getPhoneValue() { return phone.getText(); }
    public String getDateNaissValue() { return dateNaiss.getText(); }
    public String getCreateDateValue() { return createDate.getText(); }
    public String getUpdateValue() { return update.getText(); }
    public JButton getValiderButton() { return valider; }

    // ===== POINT D'ENTRÉE DU PROGRAMME (SORTI DE LA CLASSE INTERNE) =====
    public static void main(String[] args) {

    }
}