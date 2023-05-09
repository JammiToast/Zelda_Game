import java.awt.*;

public class DiagonalEnemy extends VerticalEnemy
{
    private int xSpeed;
    private int screenWidth;
    private boolean isright;
    private boolean isdown;
    
    public DiagonalEnemy(int x, int y, int w, int h, int sH, int yS, int sW, int xS) {
        super(x,y,w,h,sH,yS);
        xSpeed = xS;
        screenWidth = sW;
        isright = true;
        isdown = true;
    }
    
    public Color getColor(){
        return Color.BLACK;
    }
    
    public int getXSpeed(){
        return xSpeed;
    }

    public void move(){
        Rectangle rect = getRectangle();
        super.move();
        if(isright){
            int tempx = (int)rect.getX();
            tempx += xSpeed;
            rect.move(tempx, (int)rect.getY());
            if(rect.getX() + rect.getWidth() > screenWidth){
                isright = false;
            }
        }
        else{
            int tempx = (int)rect.getX();
            tempx -= xSpeed;
            rect.move(tempx, (int)rect.getY());
            if(rect.getX() < 0) {
                isright = true;
            }
        }
    }
}