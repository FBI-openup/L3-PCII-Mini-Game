package model;

public class Position {
    private int hauteur = 0;
    private int vitesse = 6;
    public static final int ACCEL = 6; // accélération de sauter
    private int avancement = 0;

    public int getHauteur() {
        return hauteur;
    }

    public void move() {
        // border top
        hauteur += vitesse; // appliquer la vitesse : position = dérivée de la vitesse
        vitesse -= 1; // appliquer l'accélération G : vitesse = dérivée de l'accélération
        if (hauteur < -160) {
            hauteur = -160;
        }
    }

    public void jump() {
        System.out.println("Hauteur après sauter: " + hauteur);
        vitesse = ACCEL; // sauter = appliquer une nouvelle accélération à vitesse initiale
    }

    public int getAvancement() {
        return avancement;
    }

    public void incrementAvancement(int value) {
        this.avancement += value;
    }

}