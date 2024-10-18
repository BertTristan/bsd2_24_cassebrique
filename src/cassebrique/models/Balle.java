package cassebrique.models;

import cassebrique.CasseBrique;

import java.awt.*;
import java.util.ArrayList;

public class Balle extends Rond {
    protected int vitesseX;
    protected int vitesseY;

    public Balle() {
        super();
        this.x = this.nombreAleatoire(diametre,CasseBrique.LARGEUR - diametre);
        this.y = this.nombreAleatoire(400,500);
        this.vitesseX = 3;
        this.vitesseY = -3;
        this.couleur = new Color(ratioAleatoire(), ratioAleatoire(), ratioAleatoire(0.4f,0.7f));
    }

    public Balle(int x, int y, int vitesseX, int vitesseY) {
        this.x = x;
        this.y = y;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.couleur = new Color(ratioAleatoire(), ratioAleatoire(), ratioAleatoire(0.4f,0.7f));
    }

    public Balle(int x, int y, int vitesseX, int vitesseY, Color couleur) {
        this.x = x;
        this.y = y;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.couleur = couleur;
    }

    protected float ratioAleatoire(float min, float max) {
        return (float)Math.random() * (max - min) + min;
    }

    protected float ratioAleatoire() {
        //return (float)Math.random() * 0.6f + 0.2f;
        return ratioAleatoire(0.2f, 0.8f);
    }

    protected int nombreAleatoire(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }

    public void deplacer(Barre barre, ArrayList listeBrique, ArrayList listeBonus, Graphics2D dessin) {

        x += vitesseX;
        y += vitesseY;

        if(x >= CasseBrique.LARGEUR - diametre || x <= 0) {
            vitesseX = -vitesseX;
        }

        if(y >= CasseBrique.HAUTEUR - diametre || y <= 0) {
            vitesseY = -vitesseY;
        }

        // collisions
        if (collisionsBarre(barre)){
            vitesseY = -vitesseY;
        }

        for(int i = 0; i <listeBrique.size(); i++){
            Brique brique = (Brique) listeBrique.get(i);
            if (collisionsBrique(brique)){
                vitesseY = -vitesseY;
                brique.setResistance(brique.getResistance() - 1);
                switch(brique.getResistance()){
                    case 0:
                        brique.detruireBrique(brique, listeBrique, listeBonus, dessin);
                        break;
                    case 1:
                        brique.setCouleur(Color.red);
                        break;
                    case 2:
                        brique.setCouleur(Color.orange);
                        break;
                }
            }
        }


    }

    public boolean collisionsBarre(Barre barre){
        return x + diametre >= barre.getX() && x<= barre.getX() + barre.getLargeurDefaut() && y + diametre >= barre.getY() && y<= barre.getY() + barre.getHauteurDefaut();
    }
    public boolean collisionsBrique(Brique brique){
        return x + diametre >= brique.getX() && x<= brique.getX() + Brique.getLargeurDefaut() && y + diametre >= brique.getY() && y<= brique.getY() + Brique.getHauteurDefaut();
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(int vitesseX) {
        this.vitesseX = vitesseX;
    }

    public int getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(int vitesseY) {
        this.vitesseY = vitesseY;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
