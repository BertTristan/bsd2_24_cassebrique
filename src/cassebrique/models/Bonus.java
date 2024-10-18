package cassebrique.models;

import java.awt.*;
import java.util.ArrayList;

public class Bonus extends Rond {
    protected int vitesseY;
    protected int type;
    protected boolean malus;

    public int TYPE_VITESSE;
    public int TYPE_TAILLE;

    public void deplacer(ArrayList listeBonus){
        for (int i = 0; i < listeBonus.size(); i++) {
            Bonus bonus = (Bonus) listeBonus.get(i);
            bonus.setY(bonus.getY() + vitesseY);
        }
    }




    public Bonus(int type, boolean malus, int x, int y, Color color) {
        super(x, y, color);
        this.type = type;
        this.malus = malus;
        this.vitesseY = 5;
        this.TYPE_TAILLE = 5;
        this.TYPE_VITESSE = 5;
    }


    // GETTER & SETTER
    public int getVitesseY() {
        return vitesseY;
    }
    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public boolean isMalus() {
        return malus;
    }
    public void setMalus(boolean malus) {
        this.malus = malus;
    }
    public int getTYPE_TAILLE() {
        return TYPE_TAILLE;
    }
    public void setTYPE_TAILLE(int TYPE_TAILLE) {
        this.TYPE_TAILLE = TYPE_TAILLE;
    }
    public int getTYPE_VITESSE() {
        return TYPE_VITESSE;
    }
    public void setTYPE_VITESSE(int TYPE_VITESSE) {
        this.TYPE_VITESSE = TYPE_VITESSE;
    }
}
