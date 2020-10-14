import java.awt.Color;

public class SnakePiece extends TileItem{
    int xVelocity;
    int yVelocity;

    SnakePiece following;
    SnakePiece follower;
    

    public SnakePiece(int tileX , int tileY, SnakePiece following){
        this.tileX = tileX;
        this.tileY = tileY;
        this.follower = follower;
        this.following = following;
        this.color = Color.green;
    }

    public void setFollower(SnakePiece follower){
        this.follower = follower;
    }

    public void setVelocity(int xV, int yV){
        if(following != null && xV != 0 && yV != 0){
            xVelocity = following.tileX - this.tileX;
            yVelocity = following.tileY - this.tileY;
        }else{
            xVelocity = xV;
            yVelocity = yV;
        }
        if(follower != null){
            follower.setVelocity(1,1);
        }
    }

    public void move(){
        this.setVelocity(xVelocity,yVelocity);
        tileX += xVelocity;
        tileY += yVelocity;
        if(follower != null){
            follower.move();
        }
    }
}