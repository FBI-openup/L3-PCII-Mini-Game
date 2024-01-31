package control;

import model.Descendre;
import model.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReactionClic implements MouseListener {
    private final Position position;

    public ReactionClic(Position position) {
        this.position = position;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Descendre.vitesse = 0;
        position.jump();// Augmente la hauteur de la position lorsque la souris est cliqué
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