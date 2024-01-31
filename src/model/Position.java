package model;

public class Position {
    private int hauteur = 0;
    public static final int HAUTEUR = 12;
    private int avancement = 0;

    public int getHauteur() {
        return hauteur;
    }

    public void move(int amount) {
        // border top
        if(hauteur + amount >120) {
            hauteur = 120;
        }
        hauteur += amount;
    }

    public void jump() {
        hauteur += HAUTEUR;
        System.out.println("Hauteur après sauter: " + hauteur);
    }

    public int getAvancement() {
        return avancement;
    }

    public void incrementAvancement(int value) {
        this.avancement += value;
    }
}