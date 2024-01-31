package model;

public class Descendre extends Thread {
    private final Position position;

    public Descendre(Position position) {
        this.position = position;
    }
    // Descend l'élément d'interface graphique monAffichage toutes les 200 millisecondes.

    @Override
    public void run() {
        // simulate la gravité
        int acceleration = -1; // vitesse augmente de 1 à chaque fois
        while (true) {

            try {
                position.move();
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
