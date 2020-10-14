import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;

// a board is a grid of tiles
public class Board extends JPanel{
    static final int TILE_SIZE = 20;
    static final int TILE_COUNT_X = Game.WIDTH / TILE_SIZE;
    static final int TILE_COUNT_Y = Game.HEIGHT / TILE_SIZE;

    private ArrayList<ArrayList<Tile>> board;
    private Snake snake;
    private Apple apple;

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
        apple = new Apple(3 ,3);
    }

    public Snake getSnake(){
        return snake;
    }

    private void updateSnake(){
        for(int i = 0; i < snake.getLength(); i++){
            SnakePiece currentPiece = snake.getSnakePiece(i);
            board.get(currentPiece.tileY).get(currentPiece.tileX).setChild(null);
        }
        snake.move();
        for(int i = 0; i < snake.getLength(); i++){
            SnakePiece currentPiece = snake.getSnakePiece(i);
            board.get(currentPiece.tileY).get(currentPiece.tileX).setChild(currentPiece);
        }
    }

    private void updateApple(){
        board.get(apple.tileY).get(apple.tileX).setChild(apple);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < TILE_COUNT_Y; i++){
            ArrayList<Tile> row = board.get(i);
            for(int j = 0; j < TILE_COUNT_X; j++){
                row.get(j).render(g);
            }
        }
    }
    
    public void update(){
        updateSnake();
        updateApple();
    }
}
