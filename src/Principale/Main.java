package Principale;

import Entites.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Compte c1=new Compte(1,  20000000,102,  new Date(1993, 4,13), new Date());
        Compte c2=new Compte(2, 90000000,103, new Date(1995, 7,1), new Date());
        Compte c3=new Compte(3, 50000000,103, new Date(2000, 23,12), new Date());
        Compte c4=new Compte(4, 40000000,100, new Date(2023, 4,12),new Date());
        Compte c5=new Compte(5, 600000000, 0,new Date(2005, 5,3), new Date());

        CompteSimple cs1=new CompteSimple(1,  20000000,2,  new Date(1993, 4,13), new Date(),122);
        CompteSimple cs2=new CompteSimple(2, 90000000,3, new Date(1995, 7,1), new Date(),334);
        CompteSimple cs3=new CompteSimple(3, 50000000,3, new Date(2005, 5,3), new Date(),332);
        CompteSimple cs4=new CompteSimple(4, 40000000,0, new Date(2000, 23,12),new Date(),322);
        CompteSimple cs5=new CompteSimple(5, 600000000, 10,new Date(1995, 7,1), new Date(),556);

        Personne p1=new Personne(1,"Konta","Aboubacar Salihou", 20,"aboubacarskonta@gmail.com", 70668309, new Date());
        Personne p2=new Personne(2,"KALOU","Salihou", 22,"aborskonta@gmail.com", 70622209, new Date());
        Personne p3=new Personne(3,"FANTa","ALI", 20,"aboubacarskonta@gmail.com", 70668309, new Date());
        Personne p4=new Personne(4,"TOA","KALIO", 19,"abocarskonta@gmail.com", 70663494, new Date());
        Personne p5=new Personne(1,"KONE","SABATIER", 18,"aboubacarskAMATA@gmail.com", 660668309, new Date());

        CompteEpargne ce1=new CompteEpargne(1,  20000000,22,  new Date(), new Date(),12.2f);
        CompteEpargne ce2=new CompteEpargne(2,  4000000,22,  new Date(), new Date(),1.2f);
        CompteEpargne ce3=new CompteEpargne(3,  6000000,22,  new Date(), new Date(),32.2f);
        CompteEpargne ce4=new CompteEpargne(4,  45000000,12,  new Date(), new Date(),45.2f);
        CompteEpargne ce5=new CompteEpargne(5,  55000000,11,  new Date(), new Date(),55.2f);

        ComptePayant cp1=new ComptePayant(1,  20000000,02,  new Date(), new Date());
        ComptePayant cp2=new ComptePayant(2,  55000000,02,  new Date(), new Date());
        ComptePayant cp3=new ComptePayant(3,  50000000,04,  new Date(), new Date());
        ComptePayant cp4=new ComptePayant(5,  5660000,05,  new Date(), new Date());
        ComptePayant cp5=new ComptePayant(6,  60000000,02,  new Date(), new Date());

     c1.toString();
     c2.toString();
     c3.toString();
     c4.toString();
     c5.toString();


     ce1.toString();
     ce2.toString();
     ce3.toString();
     ce4.toString();
     ce5.toString();


     p1.toString();
     p2.toString();
     p3.toString();
     p4.toString();
     p5.toString();


     cs1.toString();
     cs2.toString();
     cs3.toString();
     cs4.toString();
     cs5.toString();


     cp1.toString();
     cp2.toString();
     cp3.toString();
     cp4.toString();
     cp5.toString();




    }
}