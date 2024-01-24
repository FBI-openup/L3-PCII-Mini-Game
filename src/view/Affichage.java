package view;

import control.ReactionClic;
import model.Position;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Affichage extends JPanel {

    public static final int LARGEUR_ELLIPSE = 30;
    public static final int HAUTEUR_ELLIPSE = 120;
    public static final int X_CENTRE = 100;
    public static final int Y_CENTRE = 200;
    private Position position;
    //Tracez une ligne en utilisant les points que j'ai spécifiés.
    // Ces points sont stockés dans la liste.
    private List<Point> points;


    public Affichage(Position position) {
        this.position = position;
        // Associe l'objet model. Position passée en paramètre à l'attribut 'position' de cette instance d'view.Affichage.
        this.setPreferredSize(new Dimension(400, 300));
        // Définit la taille préférée de cet élément d'interface graphique à 400 pixels de largeur et 300 pixels de hauteur.
        this.addMouseListener(new ReactionClic(position));
        // Associe un écouteur de clics de souris à cet élément d'interface graphique.
    }


    //Utilisez paint pour afficher des points de suspension sur l'interface
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = X_CENTRE - LARGEUR_ELLIPSE / 2;
        int y = Y_CENTRE - HAUTEUR_ELLIPSE / 4 - position.getHauteur();
        g.drawOval(x, y, LARGEUR_ELLIPSE, HAUTEUR_ELLIPSE);

        points = new ArrayList<>();
        points.add(new Point(50, 250));
        points.add(new Point(100, 200));
        points.add(new Point(150, 200));
        points.add(new Point(200, 200));
        points.add(new Point(250, 150));
        points.add(new Point(300, 150));
        points.add(new Point(350, 100));

        g.setColor(Color.RED); // Définit la couleur de la ligne à rouge
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            g.drawLine(start.x, start.y, end.x, end.y);// Trace une ligne entre les points
        }

        /*public void moveLeft(int distance) {
            for (Point point : points) {
                point.x -= distance; // Déplace chaque point de la distance spécifiée vers la gauche
            }
            // Si le point le plus à gauche est en dehors de la zone de dessin, déplacez-le vers la droite
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i).x < 0) {
                    int maxX = 0;
                    for (Point p : points) {
                        if (p.x > maxX) {
                            maxX = p.x; // Trouvez le point le plus à droite
                        }
                    }
                    points.get(i).x = maxX + distance;
                    // Déplacez le point le plus à gauche vers la droite
                }
            }
        }
    */

    }
}

