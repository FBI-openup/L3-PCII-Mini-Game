import javax.swing.*;

/**
 * La classe principale de ce projet
 */
public class Main {
    /**
     * La méthode de lancement du programme
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Position position = new Position();
                JFrame maFenetre = new JFrame("Exercice 1");

                Affichage monAffichage = new Affichage(position);// Crée un objet Affichage avec l'objet Position
                ReactionClic reaction = new ReactionClic(position);// Crée un objet ReactionClic avec l'objet Position
                Redessine redessineThread = new Redessine(monAffichage);// Crée un objet Redessine avec l'objet Affichage
                redessineThread.start();


                maFenetre.add(monAffichage);
                maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                maFenetre.pack();
                maFenetre.setLocationRelativeTo(null);
                maFenetre.setVisible(true);// Rend la fenêtre visible

                Descendre descendreThread = new Descendre(position);// Crée un objet Descendre avec l'objet Position
                descendreThread.start();
            }
        });
    }
}
