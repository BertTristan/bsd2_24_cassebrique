package cassebrique.models;

import java.awt.*;
import java.util.ArrayList;

public class Brique extends Rectangle {

    protected int resistance;
    public static int hauteurDefaut = 40;
    public static int largeurDefaut = 70;

    public Brique(int x, int y, Color couleur, int resistance) {
        super(x, y, largeurDefaut, hauteurDefaut , couleur);
        this.resistance = resistance;
    }

    public Brique(int x, int y, Color couleur) {
        super(x, y, largeurDefaut, hauteurDefaut , couleur);
        this.resistance = 1;
    }

    public void detruireBrique(Brique brique, ArrayList listeBrique, ArrayList listeBonus,Graphics2D dessin){
        listeBrique.remove(brique);

        if((int)(Math.random()* 10) == 0){ //10%
            System.out.println("test");
            if((int)(Math.random()*2) == 1){ //50% Bonus
                if((int)(Math.random()*2) == 1){ // 50% Taille
                    listeBonus.add(new Bonus(1, false, brique.getX() + largeurDefaut / 2, brique.getY() + hauteurDefaut / 2, Color.BLUE));
                } else { // 50% Vitesse
                    listeBonus.add(new Bonus(0, false, brique.getX() + largeurDefaut / 2, brique.getY() + hauteurDefaut , Color.GREEN));
                }
            } else { // 50% Malus
                if((int)(Math.random()*2) == 1){ // 50% Taille
                    listeBonus.add(new Bonus(1, true, brique.getX() + largeurDefaut / 2, brique.getY() + hauteurDefaut , Color.RED));
                } else { // 50% Vitesse
                    listeBonus.add(new Bonus(0, true, brique.getX() + largeurDefaut / 2, brique.getY() + hauteurDefaut , Color.ORANGE));
                }
            }
        }
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public static int getHauteurDefaut() {
        return hauteurDefaut;
    }

    public static void setHauteurDefaut(int hauteurDefaut) {
        Brique.hauteurDefaut = hauteurDefaut;
    }

    public static int getLargeurDefaut() {
        return largeurDefaut;
    }

    public static void setLargeurDefaut(int largeurDefaut) {
        Brique.largeurDefaut = largeurDefaut;
    }
}
