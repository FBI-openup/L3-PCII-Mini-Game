package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    private final Random generateurAleatoire = new Random();
    //l’écart minimum et maximum en X entre deux points successifs (sauf pour les deux premiers points)
    private static final int X_MIN = 50; //distance horizontal minimum entre deux points
    private static final int X_MAX = 60;//distance horizontal maximum entre deux points
    private final ArrayList<Point> points;
    //Tracez une ligne en utilisant les points que j'ai spécifiés.
    // Ces points sont initialisé par random et puis stockés dans la liste.
    private final Position position;

    public Parcours(Position position) {
        this.position = position;
        points = new ArrayList<>();
        initializePoints();
    }

    public void initializePoints() {
        int currentX = 80;
        int startY = 100;
        points.add(new Point(20, 130));
        points.add(new Point(80, 100));
        while (currentX <= 400) {
            int xIncrement = X_MIN + generateurAleatoire.nextInt(X_MAX - X_MIN + 4);
            currentX += xIncrement;
            int yIncrement = startY + generateurAleatoire.nextInt(60);
            Point point = new Point(currentX, yIncrement);
            points.add(point);
        }
    }

    public ArrayList<Point> getAdjustedPoints() {
        ArrayList<Point> adjustedPoints = new ArrayList<>();
        for (Point point : this.points) {
            int adjustedX = point.x - this.position.getAvancement();
            adjustedPoints.add(new Point(adjustedX, point.y));
        }
        updatePoints();
        return adjustedPoints;
    }

    //Ajouter et supprimer des points pour que la ligne soit toujours infinie
    public void updatePoints() {
        //supprimer le dernier point qui est hors de la fenetre
        if (this.points.size() > 1 && this.points.get(1).x - this.position.getAvancement() < 0) {
            this.points.remove(0);
        }

        // ajouter un nouveau point si le dernier point est proche de la fenetre
        Point lastPoint = this.points.get(this.points.size() - 1);
        if (lastPoint.x - this.position.getAvancement() < 400) {
            int newX = lastPoint.x + X_MIN + generateurAleatoire.nextInt(X_MAX - X_MIN + 1);
            int newY = 80 + generateurAleatoire.nextInt(80); // peut adjuster
            this.points.add(new Point(newX, newY));
        }
    }

    //pour obtenir la position de 80,Y de la ligne
    public double getPosi80Y() {
        // parcourir tous les points pour trouver le segment qui contient x=80
        updatePoints();
        for (int i = 1; i < getAdjustedPoints().size() - 1; i++) {
            Point p2 = getAdjustedPoints().get(i);
            if (p2.x >= 80) {
                // trouver le premier point qui est plus grand que 80
                Point p1 = getAdjustedPoints().get(i - 1); // retrouver le point précédent
            if (p1.x <= 80 && p2.x >= 80) {
                double pente = (double) (p2.y - p1.y) / (p2.x - p1.x);
                double yIntercept = p1.y - pente * p1.x;
                return pente * 80 + yIntercept;
            }}
        }
        return -1;
    }
    /* pour tester la ligne, par afficher les points dans la console
    public static void main(String[] args) {
        Position position = new Position();
        Parcours parcours = new Parcours(position);
        ArrayList<Point> adjustedPoints = parcours.getAdjustedPoints();
        for (Point point : adjustedPoints) {
            System.out.println("X: " + point.getX() + ", Y: " + point.getY());
         }
    }*/
}