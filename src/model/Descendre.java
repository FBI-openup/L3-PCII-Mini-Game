package model;

import static java.lang.Thread.sleep;

public class Descendre extends Thread {
    private final Position position;

    public Descendre(Position position) {
        this.position = position;
    }
    // Descend l'élément d'interface graphique monAffichage toutes les 200 millisecondes.
    @Override
    public void run() {
        while (true) {

            if (position.getHauteur() > -160) {
                position.move(-2);
                // Simuler une descente en vitesse constante de -2
            }
            try {
                sleep(50);
                // Met en pause le thread pendant 50 millisecondes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
