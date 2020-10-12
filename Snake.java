import java.util.ArrayList;

public class Snake{

    private ArrayList<SnakePiece> snake;
    private int head_x; 
    private int head_y;

    public Snake(int head_x, int head_y){
        this.head_x = head_x;
        this.head_y = head_y;
        snake = new ArrayList<SnakePiece>();
        for(int i = 0; i < 3; i++){
            snake.add(new SnakePiece(head_x - i, head_y));
        }
    }

    public int getLength(){
        return snake.size();
    }
    
    public SnakePiece getSnakePiece(int index){
        return snake.get(index);
    }
}