package view;

import control.ReactionClic;
import model.Parcours;
import model.Position;
import model.Score;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    public static final int LARGEUR_ELLIPSE = 30;
    public static final int HAUTEUR_ELLIPSE = 80;
    public static final int X_CENTRE = 80; //point de départ (80,100)
    public static final int Y_CENTRE = 100;
    private final Position position;
    private final Parcours parcours;
    public static boolean gameover = false;
    private Score scoreTracker;

    public Affichage(Position position, Parcours parcours, Score score) {
        this.position = position;
        this.parcours = parcours;//Peut désormais accepter une instance de parcours
        this.scoreTracker = score;

        // Associe l'objet model. Position passée en paramètre à l'attribut 'position' de cette instance de view. Affichage.
        this.setPreferredSize(new Dimension(400, 300));
        // Définit la taille préférée de cet élément d'interface graphique à 400 pixels de largeur et 300 pixels de hauteur.
        this.addMouseListener(new ReactionClic(position));
        // Associe un écouteur de clics de souris à cet élément d'interface graphique.
    }
    public void gameover(){
        this.gameover = true;
        repaint();
    }
    //Utilisez paint pour afficher des points de suspension sur l'interface
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint ellipse
        int x = X_CENTRE - LARGEUR_ELLIPSE / 2;
        int y = Y_CENTRE - HAUTEUR_ELLIPSE / 2 - position.getHauteur();
        g.setColor(Color.BLUE);
        g.drawOval(x, y, LARGEUR_ELLIPSE, HAUTEUR_ELLIPSE);

        // paint ligne brisée
        ArrayList<Point> adjustedPoints = parcours.getAdjustedPoints();

        if (adjustedPoints.size() > 1) {
            Point prevPoint = adjustedPoints.get(0);
            for (int i = 1; i < adjustedPoints.size(); i++) {
                Point currentPoint = adjustedPoints.get(i);
                g.setColor(Color.GREEN);
                g.drawLine(prevPoint.x, prevPoint.y, currentPoint.x, currentPoint.y);
                prevPoint = currentPoint;
            }
        }
        //paint Measure points
        int posY = (int) parcours.getPosi80Y();
        g.setColor(Color.RED);
        g.fillOval(80 - 2, posY - 2, 4, 4);//paint un cercle pour represent le point de Mesure

        g.setColor(Color.BLACK);//paint un point pour represent le tete d'ellipse
        g.fillOval(80 - 2, 100-position.getHauteur() + 40 - 2, 4, 4);
        g.setColor(Color.BLACK);//paint un point pour represent le pied d'ellipse
        g.fillOval(80 - 2, 100-position.getHauteur() - 40 - 2, 4, 4);
        //paint game over
        if (gameover) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            int X = (this.getWidth() - g.getFontMetrics().stringWidth("Game Over")) / 2;
            int Y = this.getHeight() / 2;
            g.drawString("Game Over", X, Y);
        }
        //paint score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        int X = 40;
        int Y = 60;
        g.drawString("SCORE :"+scoreTracker.getScore(), X, Y);
    }
}

