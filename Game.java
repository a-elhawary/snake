import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game{
    final static int WIDTH = 800;
    final static int HEIGHT = 800;
    final String TITLE = "Snake Game v1.0";

    public Game(){
        // initialize window
        JFrame frame = new JFrame(TITLE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //board is a JPanel which renders the game
        Board board = new Board();
        frame.add(board);
        frame.addKeyListener(new myKeyListener(board));
        frame.setVisible(true);
        Thread loopThread = new Thread(new GameLoop(board));
        loopThread.start();
    }


    public static void main(String args[]){
        new Game();
    }

    private class myKeyListener extends KeyAdapter{
        Board board;

        public myKeyListener(Board board){
            this.board = board;
        }

        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case 37:
                    board.getSnake().setVelocity(-1*Snake.VELOCITY,0);
                    break;
                case 38:
                    board.getSnake().setVelocity(0,-1*Snake.VELOCITY);
                    break;
                case 39:
                    board.getSnake().setVelocity(1*Snake.VELOCITY,0);
                    break;
                case 40:
                    board.getSnake().setVelocity(0,1*Snake.VELOCITY);
                    break;
            }
        }
    }
}