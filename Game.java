import javax.swing.JFrame;

public class Game{
    final static int WIDTH = 800;
    final static int HEIGHT = 800;
    final static String TITLE = "Snake Game v1.0";

    public static void main(String args[]){
        // initialize window
        JFrame frame = new JFrame(TITLE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //board is a JPanel which renders the game
        Board board = new Board();
        frame.add(board);
        frame.setVisible(true);
    }
}