package Entites;

import java.util.Date;



// Import Date retiré car inutile selon le diagramme
public class Compte {
    private int code;
    protected float solde;
    private static int nbComptes;
    private Date createdDate;
    private  Date update;
    private Object s;

    public Compte( int code, float solde,int nbComptes, Date createdDate, Date update ) {
        ++nbComptes;
        code = nbComptes;
        this.code= code;
        this.solde = solde;
        Compte.nbComptes = nbComptes;
        this.createdDate= createdDate;
        this.update=update;
    }



    public Compte() {

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
    public String toString() {
         String s="Compte{" +
                "code=" + code +
                ", solde=" + solde +
                ", createdDate=" + createdDate +
                ", update=" + update +
                '}';
        System.out.println(s);
        return s;
    }

}