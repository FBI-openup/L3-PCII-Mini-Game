package view;

import control.ReactionClic;
import model.Position;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class Affichage extends JPanel {

    public static final int LARGEUR_ELLIPSE = 30;
    public static final int HAUTEUR_ELLIPSE = 120;
    public static final int X_CENTRE = 100;
    public static final int Y_CENTRE = 200;
    private Position position;

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
        }
    }
