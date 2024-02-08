package model;

public class ParcoursMove extends Thread {
    private final Position position;

    public ParcoursMove(Position position) {
        this.position = position;
    }

    @Override
    // chaque 50 milliseconds la position avance de
    public void run() {
        while (true) {
            try {
                position.incrementAvancement(1);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
