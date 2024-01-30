package model;

public class Position {
    private int hauteur = 0;
    public static final int HAUTEUR = 20;

    public int getHauteur() {
        return hauteur;
    }

    public void move(int amount) {
        if(hauteur + amount >120) {
            hauteur = 120;
        }
        hauteur += amount;
    }

    public void jump() {
        hauteur += HAUTEUR;
        System.out.println("Hauteur après sauter: " + hauteur);
    }
}