package Entites;

import java.util.Date;

public class CompteSimple extends Compte {
    private float decouvert;

    public CompteSimple(int code, float solde, int nbComptes, Date createdDate, Date update, float decouvert) {
        super();
        this.decouvert = decouvert;
        this.solde=solde;


    }

    @Override
    public String toString() {
        String s= "CompteSimple{" +
                "decouvert=" + decouvert +
                '}';
        System.out.println(s);
        return s;
    }

    @Override
    public void retirer(float mt) {
        // Logique : on peut retirer si le montant est inférieur au solde + le découvert autorisé
        if (mt <= solde + decouvert) {
            solde -= mt;
        }
    }

}