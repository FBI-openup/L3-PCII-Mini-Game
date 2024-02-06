package view;

import model.ParcoursMove;

public class Redessine extends Thread {
    private final Affichage monAffichage;
    private final ParcoursMove parcoursMove;
    private static final int DELAY = 25;

    public Redessine(Affichage monAffichage, ParcoursMove parcoursMove) {
        this.monAffichage = monAffichage;
        this.parcoursMove = parcoursMove;
    }

    // view.Redessine l'élément d'interface graphique monAffichage toutes les 50 millisecondes.
    @Override
    public void run() {
        while (true) {
            // view.Redessine l'élément d'interface graphique monAffichage.
            try {
                Thread.sleep(DELAY);
                monAffichage.repaint();// Mise à jour de l'affichage

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

