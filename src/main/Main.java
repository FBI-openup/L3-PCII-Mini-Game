package main;

import model.*;
import view.Redessine;
import view.Affichage;

import javax.swing.*;

/**
 * La classe principale de ce projet
 */
public class Main {
    /**
     * La méthode de lancement du programme
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Position position = new Position();
            Parcours parcours = new Parcours(position);
            ParcoursMove parcoursMove = new ParcoursMove(position);

            JFrame maFenetre = new JFrame("MINI Game: Dont touch ");// Crée une fenêtre avec le titre "MINI Game : Dont touch "

            Score score = new Score();
            Affichage monAffichage = new Affichage(position, parcours, score);
            Redessine redessineThread = new Redessine(monAffichage, parcoursMove);
            Descendre descendreThread = new Descendre(position);
            Collision collision = new Collision(monAffichage, position, parcours);

            //threads
            score.start();
            redessineThread.start();
            parcoursMove.start();
            descendreThread.start();
            collision.start();


            maFenetre.add(monAffichage);
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.pack();
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setVisible(true);// Rend la fenêtre visible
        });
    }
}
