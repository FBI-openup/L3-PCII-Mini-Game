package view;

import control.ReactionClic;
import model.Parcours;
import model.Position;

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

    public Affichage(Position position,Parcours parcours) {
        this.position = position;
        this.parcours = parcours;//Peut désormais accepter une instance de parcours
        // Associe l'objet model. Position passée en paramètre à l'attribut 'position' de cette instance de view. Affichage.
        this.setPreferredSize(new Dimension(400, 300));
        // Définit la taille préférée de cet élément d'interface graphique à 400 pixels de largeur et 300 pixels de hauteur.
        this.addMouseListener(new ReactionClic(position));
        // Associe un écouteur de clics de souris à cet élément d'interface graphique.
    }
//    public void updateAndRepaint() {
//        parcours.updatePoints();
//        this.repaint();
//    }
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
                g.setColor(Color.RED);
                g.drawLine(prevPoint.x, prevPoint.y, currentPoint.x, currentPoint.y);
                prevPoint = currentPoint;
            }
        }
    }
}

