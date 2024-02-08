package model;
import view.Affichage;
public class Score extends Thread {
    private int score = 0;


    public Score() {
        this.score = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                incrementScore(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupted status
            }
        }
    }

    private void incrementScore(int increment) {
        if (!Affichage.gameover)this.score += increment;
    }

    public int getScore() {
        return this.score;
    }
}