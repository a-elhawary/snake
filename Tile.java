import java.awt.Graphics;
import java.awt.Color;

public class Tile{
    private int x;
    private int y;
    private int tileSize;
    private TileItem child;

    public Tile(int x, int y, int tileSize){
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        child = null;
    }

    public void setChild(TileItem child){
        this.child = child;
    }

    public void render(Graphics g){
        int borderSize = 0;
        g.setColor(Color.black);
        g.fillRect(x, y, tileSize, tileSize);
        if(child != null){
            g.setColor(child.color);
            borderSize = 1;
        }
        g.fillRect(x+borderSize, y-borderSize, tileSize-borderSize*2, tileSize-borderSize*2);        
    }
}