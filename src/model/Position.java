package model;

public class Position {
    private int hauteur = 0;
    public static final int HAUTEUR = 10;

    public int getHauteur() {
        return hauteur;
    }

    public void move(int amount) {
        if(hauteur + amount > 180) {
            hauteur = 180;
        }
        hauteur += amount;
    }

    public void jump() {
        hauteur += HAUTEUR;
        System.out.println("Hauteur après sauter: " + hauteur);
    }
}