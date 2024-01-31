package model;

public class Descendre extends Thread {
    private final Position position;

    public Descendre(Position position) {
        this.position = position;
    }
    // Descend l'élément d'interface graphique monAffichage toutes les 200 millisecondes.

    // simulate la gravité

    //TODO need reset v,a=0 now need to <0

    @Override
    public void run() {
        int vitesse = -2; // vitesse initiale
        int acceleration = 0; // vitesse augmente de 1 à chaque fois

        while (true) {

            try {
                //border bas
                if (position.getHauteur() > -160) {
                    position.move(vitesse);
                    vitesse += acceleration; // mise à jour de la vitesse chaque boucle
                }
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
