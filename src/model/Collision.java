package model;

import view.Affichage;

public class Collision extends Thread {
    private final Affichage affichage;
    private final Position position;
    private final Parcours parcours;

    public Collision(Affichage affichage, Position position, Parcours parcours) {
        this.affichage = affichage;
        this.position = position;
        this.parcours = parcours;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (checkCollision()) {
                    affichage.gameover();
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkCollision() {
        int tete = 100-position.getHauteur() + 40;//position tete d'ELLIPSE
        int pied = 100-position.getHauteur() - 40;//position tail d'ELLIPSE
        double posi_80_Y = parcours.getPosi80Y();//
        if (tete < posi_80_Y || pied > posi_80_Y) {
            return true;
        } else return false;
    }
}
