package Entites;

import java.util.Date;

public class CompteEpargne extends Compte {
    private float taux;

    // Constructeur
    public CompteEpargne(int code, float solde, int nbComptes, Date createdDate, Date update, float taux) {
        super(); // Appelle le constructeur de Compte pour le code et le solde
        this.taux = taux;
    }

    public CompteEpargne(int code, float solde, int nbComptes, Date createdDate, Date update) {
        super(code, solde, nbComptes, createdDate, update);
    }

    // Méthode spécifique demandée dans le diagramme
    public void calculInterets() {
        // La logique : on ajoute les intérêts au solde actuel
        solde = solde + (solde * taux);
    }
    @Override
    public String toString() {
        String s= "CompteEpargne{" +
                "taux=" + taux +
                '}';
        System.out.println(s);
        return s;
    }


}