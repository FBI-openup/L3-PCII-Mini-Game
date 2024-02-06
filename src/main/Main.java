package main;

import view.Redessine;
import model.Descendre;
import model.ParcoursMove;
import model.Parcours;
import model.Position;
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
            ParcoursMove parcoursMove = new ParcoursMove( position);

            JFrame maFenetre = new JFrame("MINI Game: Dont touch ");// Crée une fenêtre avec le titre "MINI Game : Dont touch "

            Affichage monAffichage = new Affichage(position,parcours);// Crée un objet view. Affichage Avec l'objet model. Position
            Redessine redessineThread = new Redessine(monAffichage, parcoursMove);// Crée un objet view.Redessine Avec l'objet view. Affichage
            Descendre descendreThread = new Descendre(position);// Crée un objet model. Descendre Avec l'objet model. Position

            //threads
            redessineThread.start();
            parcoursMove.start();
            descendreThread.start();


            maFenetre.add(monAffichage);
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.pack();
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setVisible(true);// Rend la fenêtre visible




        });
    }
}
