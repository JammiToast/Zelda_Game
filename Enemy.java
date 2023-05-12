import java.awt.*;

public abstract class Enemy 
{
    private Rectangle rect;
    
    public Enemy(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
    }
    
    public Rectangle getRectangle() {
        return rect;
    }
    
    public boolean intersects(Rectangle p) {
        return rect.intersects(p);
    }
       
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }

    /** A method that sets the enemy to a dormant state
     * 
     */
    public void setDormant(){
        rect.x = -100;
        rect.y = -100;
    }
    
    public abstract Color getColor();
    
    public abstract void move();
}