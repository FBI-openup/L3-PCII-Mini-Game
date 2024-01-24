package control;

import model.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReactionClic implements MouseListener {
    private Position position;

    public ReactionClic(Position position) {
        this.position = position;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        position.jump();// Augmente la hauteur de la position lorsque la souris est cliquée
        System.out.println("clicked :)");// Affiche "Clic de souris " dans la console
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}