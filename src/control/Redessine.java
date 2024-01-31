package control;

import view.Affichage;

public class Redessine extends Thread {
    private final Affichage monAffichage;
    private static final int DELAY = 50;
    public Redessine(Affichage monAffichage) {
        this.monAffichage = monAffichage;
    }
    // control.Redessine l'élément d'interface graphique monAffichage toutes les 50 millisecondes.
    @Override
    public void run() {
        while (true) {
            // control.Redessine l'élément d'interface graphique monAffichage.
            monAffichage.updateAndRepaint(); // Mise à jour de l'affichage
            try {
                Thread.sleep(DELAY);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

