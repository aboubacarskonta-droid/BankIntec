package Entites;

import java.util.Date;

public class ComptePayant extends Compte {
    // Le diagramme ne précise pas de frais, on utilise souvent 5% ou 1 unité.
    // Ici, on va déduire 5% (0.05f) à chaque opération.

    public ComptePayant() {
        super();
    }

    @Override
    public void verser(float mt) {
        // On verse le montant moins les frais
        super.verser(mt - (mt * 0.05f));
    }

    public ComptePayant(int code, float solde, int nbComptes, Date createdDate, Date update) {
        super(code, solde, nbComptes, createdDate, update);
    }

    @Override
    public String toString() {
        String s= "ComptePayant{" +
                "solde=" + solde +
                '}';
        System.out.println(s);
        return s;

    }

    @Override
    public void retirer(float mt) {
        // On retire le montant plus les frais
        super.retirer(mt + (mt * 0.05f));
    }

}