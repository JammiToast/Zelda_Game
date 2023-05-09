import java.awt.*;

public class StalkerEnemy extends Enemy
{
    private Rectangle playerRect;
    
    public StalkerEnemy(int x, int y, int w, int h, Rectangle p) {
        super(x,y,w,h);
        playerRect = p;
    }
    
    public Color getColor(){
        return Color.YELLOW;
    }
    
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("bee.png");
    }
    
    public void move(){
        Rectangle ourRect = getRectangle();
        int currentY = (int)ourRect.getY();
        int currentX = (int)ourRect.getX();
        if(playerRect.getX() > ourRect.getX()){
            currentX++;
        }
        else if(playerRect.getX() < ourRect.getX()){
            currentX--;
        }
        if(playerRect.getY() > ourRect.getY()){
            currentY++;
        }
        else if(playerRect.getY() < ourRect.getY()){
            currentY--;
        }
        ourRect.move(currentX,currentY);
    }
}