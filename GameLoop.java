import java.lang.Runnable;

public class GameLoop implements Runnable{
    boolean isRunning = true;
    Board board;

    public GameLoop(Board board){
        this.board = board;
    }

    public void run(){
        long startTime = System.nanoTime();
        int FPS = 60;
        int UPS = 25;
        double deltaF = 0;
        double deltaU = 0;
        double fns = 1000000000/FPS;
        double uns = 1000000000/UPS;

        while(isRunning){
            long currentTime = System.nanoTime();
            deltaF += (currentTime - startTime)/fns;
            deltaU += (currentTime - startTime)/uns;
            startTime = currentTime;
            if(deltaF >= 1){
                deltaF--;
                board.repaint();
            }
            if(deltaU >= 1){
                deltaU--;
                board.update();
            }
        }
    }
}