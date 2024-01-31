package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    private final Random generateurAleatoire = new Random();
    //l’écart minimum et maximum en X entre deux points successifs (sauf pour les deux premiers points)
    private static final int X_MIN = 10;
    private static final int X_MAX = 30;
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
        int currentX = 0;
        int startY = 80;

        while (currentX <= 400) {
            int xIncrement = X_MIN + generateurAleatoire.nextInt(X_MAX - X_MIN + 4);
            currentX += xIncrement;
            int yIncrement = startY+generateurAleatoire.nextInt(100);
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
        return adjustedPoints;
    }
    public void updatePoints() {
        //suprimer le dernier point qui est hors de la fenetre
        if (this.points.size() > 1 && this.points.get(1).x - this.position.getAvancement() < 0) {
            this.points.remove(0);
        }

        // ajouter un nouveau point si le dernier point est proche de la fenetre
        Point lastPoint = this.points.get(this.points.size() - 1);
        if (lastPoint.x - this.position.getAvancement() < 400) {
            int newX = lastPoint.x + X_MIN + generateurAleatoire.nextInt(X_MAX - X_MIN + 1);
            int newY = 80 + generateurAleatoire.nextInt(160); // peut adjuster
            this.points.add(new Point(newX, newY));
        }
    }
    public static void main(String[] args) {
        Position position = new Position();
        Parcours parcours = new Parcours(position);
        ArrayList<Point> adjustedPoints = parcours.getAdjustedPoints();

        for (Point point : adjustedPoints) {
            System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        }
    }
}