import java.awt.*;

public class VerticalEnemy extends Enemy
{
    private int screenHeight;
    private int ySpeed;
    private boolean isdown;
    
    public VerticalEnemy(int x, int y, int w, int h, int sH, int yS) {
        super(x,y,w,h);
        screenHeight = sH;
        ySpeed = yS;
        isdown = true;
    }
    
    public Color getColor(){
        return Color.RED;
    }
    
    public int getYSpeed(){
        return ySpeed;
    }
    
    public int getScreenHeight(){
        return screenHeight;
    }
    
    public void changeSpeed(int speed){
        ySpeed = speed;
    }
    
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("thwomp.png");
    }
    
    public void move(){
        Rectangle rect = getRectangle();
        if(isdown){
            int tempy = (int)rect.getY();
            tempy += ySpeed;
            rect.move((int)rect.getX(), tempy);
            if(rect.getY() + rect.getHeight() > screenHeight) {
                isdown = false;
            }
        }
        else{
            int tempy = (int)rect.getY();
            tempy -= ySpeed;
            rect.move((int)rect.getX(), tempy);
            if(rect.getY() < 0) {
                isdown = true;
            }
        }
    }
}