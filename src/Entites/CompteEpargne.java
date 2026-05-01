package Entites;

public class CompteEpargne extends Compte {
    private float taux;

    // Constructeur
    public CompteEpargne(float taux) {
        super(); // Appelle le constructeur de Compte pour le code et le solde
        this.taux = taux;
    }

    // Méthode spécifique demandée dans le diagramme
    public void calculInterets() {
        // La logique : on ajoute les intérêts au solde actuel
        solde = solde + (solde * taux);
    }

    @Override
    public String toString() {
        // On réutilise le toString du parent et on ajoute le taux
        return "Compte Epargne " + super.toString() + " Taux=" + taux;
    }
}