import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

// a board is a grid of tiles
public class Board extends JPanel implements KeyListener{
    static final int TILE_SIZE = 20;
    static final int TILE_COUNT_X = Game.WIDTH / TILE_SIZE;
    static final int TILE_COUNT_Y = Game.HEIGHT / TILE_SIZE;

    private ArrayList<ArrayList<Tile>> board;
    private Snake snake;

    public Board(){
        board = new ArrayList<ArrayList<Tile>>();
        //fill board
        for(int i = 0; i < TILE_COUNT_Y; i++){
            ArrayList<Tile> row = new ArrayList<Tile>();
            board.add(row);
            for(int j = 0; j < TILE_COUNT_X; j++){
                // x coordinate is the left most point of the tile, 
                // which is how many tils have been created multiplied by the TILE_SIZE
                // same goes for the y coordinate
                row.add(new Tile(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE));
            }
        }
        // make snake
        snake = new Snake(10,10);
    }

    private void addSnake(){
        for(int i = 0; i < snake.getLength(); i++){
            SnakePiece currentPiece = snake.getSnakePiece(i);
            board.get(currentPiece.tileY).get(currentPiece.tileX).setChild(currentPiece);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }
    
    public void render(Graphics g){
        addSnake();
        for(int i = 0; i < TILE_COUNT_Y; i++){
            ArrayList<Tile> row = board.get(i);
            for(int j = 0; j < TILE_COUNT_X; j++){
                row.get(j).render(g);
            }
        }
    }
    
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
}