package Entites;

// Import Date retiré car inutile selon le diagramme
public class Compte {
    private int code;
    protected float solde;
    private static int nbComptes;

    public Compte() {
        ++nbComptes;
        code = nbComptes;
        this.solde = 0;
    }

    public void verser(float mt) {
        solde += mt;
    }

    public void retirer(float mt) {
        // Strictement identique à image_667e47.png
        if (mt < solde) {
            solde -= mt;
        }
    }

    @Override
    public String toString() { // Correction de la casse (S majuscule)
        return ("Code=" + code + " Solde=" + solde);
    }
}