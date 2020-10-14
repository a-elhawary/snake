import java.util.ArrayList;

public class Snake{
    public static int VELOCITY = 1;
    private final int INIT_SIZE = 9;

    private SnakePiece head;
    private SnakePiece tail;

    private ArrayList<SnakePiece> snake;


    public Snake(int head_x, int head_y){
        snake = new ArrayList<SnakePiece>();
        head = new SnakePiece(head_x, head_y, null);
        snake.add(head);
        SnakePiece current = head;
        for(int i = 1; i < INIT_SIZE; i++){
            SnakePiece newPiece =  new SnakePiece(head_x - i, head_y, current);
            snake.add(newPiece);
            current.setFollower(newPiece);
            current = newPiece;
        }
        current.setFollower(null);
    }

    public int getLength(){
        return snake.size();
    }
    
    public SnakePiece getSnakePiece(int index){
        return snake.get(index);
    }

    public void setVelocity(int xV, int yV){
        if(!(head.tileX + xV == head.follower.tileX && head.tileY + yV == head.follower.tileY)){
            head.setVelocity(xV, yV);
        }
    }

    public void move(){
        head.move();
    }
}