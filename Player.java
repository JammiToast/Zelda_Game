import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;

public class Player {
    private Rectangle rect;
    private int xSpeed;
    private int ySpeed;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public Player(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
        xSpeed = 3;
        ySpeed = 3;
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public Rectangle getRectangle() {
        return rect;
    }

    public void setY(int d) {
        rect.y = d;
    }

    public void setX(int d) {
        rect.x = d;
    }

    public int getY() {
        return rect.y;
    }

    public int getX() {
        return rect.x;
    }

    public void setDirections(boolean u, boolean d, boolean l, boolean r){
        up = u;
        down = d;
        left = l;
        right = r;
    }

    public void draw(Graphics g){
        g.drawImage(getImage(), (int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight(), null);
    }

    public Image getImage(){
        //return ImageLoader.loadCompatibleImage("thwomp.png");
        if(up == true && down == false){
            return ImageLoader.loadCompatibleImage("LinkFacingUp.png");
        }
        else if(left == true && right == false){
            return ImageLoader.loadCompatibleImage("LinkFacingLeft.png");
        }
        else if(right == true && left == false){
            return ImageLoader.loadCompatibleImage("LinkFacingRight.png");
        }
        else{
            return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
        }
    }
}
