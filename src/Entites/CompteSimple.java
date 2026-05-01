package Entites;

public class CompteSimple extends Compte {
    private float decouvert;

    public CompteSimple(float decouvert) {
        super();
        this.decouvert = decouvert;
    }

    public CompteSimple() {
        this(0); // Appelle le premier constructeur avec 0 par défaut
    }

    @Override
    public void retirer(float mt) {
        // Logique : on peut retirer si le montant est inférieur au solde + le découvert autorisé
        if (mt <= solde + decouvert) {
            solde -= mt;
        }
    }

    @Override
    public String toString() {
        // Conforme à image_66777c.png
        return ("Compte Simple " + super.toString() + " Decouvert=" + decouvert);
    }
}