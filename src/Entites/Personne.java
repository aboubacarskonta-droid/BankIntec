package Entites;

import java.util.Date;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private int phone;
    private Date dateNaiss;
    private Date createdDate;
    private Date updateDate;

    // Constructeur complet
    public Personne(int id, String nom, String prenom, int age, String adresse, int phone, Date dateNaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.phone = phone;
        this.dateNaiss = dateNaiss;
        this.createdDate = new Date(); // Initialise la date de création à l'instant T
    }

    @Override
    public String toString() {
        String s= "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", adresse='" + adresse + '\'' +
                ", phone=" + phone +
                ", dateNaiss=" + dateNaiss +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                '}';
        System.out.println(s);
        return s;
    }
}