package Entites;

import java.util.Date;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String phone;
    private Date dateNaiss;
    private Date createdDate;
    private Date updateDate;

    // Constructeur complet
    public Personne(int id, String nom, String prenom, int age, String adresse, String phone, Date dateNaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.phone = phone;
        this.dateNaiss = dateNaiss;
        this.createdDate = new Date(); // Initialise la date de création à l'instant T
    }

    // Un toString pour afficher les infos de la personne
    @Override
    public String toString() {
        return nom + " " + prenom + " (ID: " + id + ")";
    }
}