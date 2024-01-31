package main;

import control.Redessine;
import model.Descendre;
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
            JFrame maFenetre = new JFrame("MINI Game: Dont touch ");// Crée une fenêtre avec le titre "MINI Game : Dont touch "

            Affichage monAffichage = new Affichage(position,parcours);// Crée un objet view. Affichage avec l'objet model. Position
            Redessine redessineThread = new Redessine(monAffichage);// Crée un objet control.Redessine avec l'objet view. Affichage
            redessineThread.start();



            maFenetre.add(monAffichage);
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.pack();
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setVisible(true);// Rend la fenêtre visible

            Descendre descendreThread = new Descendre(position);// Crée un objet model. Descendre
                                                                // Avec l'objet model. Position
            descendreThread.start();


            Timer timer = new Timer(50, e -> position.incrementAvancement(1));
            timer.start();
        });
    }
}
