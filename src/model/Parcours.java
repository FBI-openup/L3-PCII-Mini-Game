package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    private final Random generateurAleatoire = new Random();
    //l’écart minimum et maximum en X entre deux points successifs (sauf pour les deux premiers points)
    private static final int X_MIN = 10;
    private static final int X_MAX = 30;
    private ArrayList<Point> points;//Tracez une ligne en utilisant les points que j'ai spécifiés.
    // Ces points sont initialisé par random et puis stockés dans la liste.
    public void initializePoints() {
        int currentX = 0;
        int startY = 180;

        while (currentX <= 400) {
            int xIncrement = X_MIN + generateurAleatoire.nextInt(X_MAX - X_MIN + 2);
            currentX += xIncrement;
            int yIncrement = startY+generateurAleatoire.nextInt(80);
            Point point = new Point(currentX, yIncrement);
            points.add(point);
        }
    }
    public Parcours() {
        points = new ArrayList<>();
        initializePoints();
    }
    //for print test
    public ArrayList<Point> getPoints() {
        return points;
    }
    public static void main(String[] args) {
        Parcours parcours = new Parcours();
        ArrayList<Point> generatedPoints = parcours.getPoints();

        for (Point point : generatedPoints) {
            System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        }
    }
}