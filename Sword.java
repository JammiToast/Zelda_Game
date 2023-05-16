import java.awt.*;

public class Sword {
    private Rectangle rect;
    private int direction;
    private int speed;

    public Sword(int x, int y, int w, int h, int dir, int s){
        int realx = x;
        int realy = y;
        if(dir == 2){
            realy = y + 50;
        }
        if(dir == 1){
            realy = y - 50;
        }
        if(dir == 3){
            realx = x - 50;
        }
        if(dir == 4){
            realx = x + 50;
        }
        rect = new Rectangle(realx, realy, w, h);
        direction = dir;
        speed = s;
    }

    public Rectangle getRectangle(){
        return rect;
    }

    public int getX(){
        return (int)rect.getX();
    }

    public int getY(){
        return (int)rect.getY();
    }

    public boolean instersects(Rectangle p){
        return rect.intersects(p);
    }

    public void draw(Graphics g){
        g.drawImage(getImage(), (int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight(), null);
    }

    public Image getImage(){
        if(direction == 2){
            return ImageLoader.loadCompatibleImage("SwordDown.png");
        }
        else if(direction == 1){
            return ImageLoader.loadCompatibleImage("SwordUp.png");
        }
        else if(direction == 3){
            return ImageLoader.loadCompatibleImage("SwordLeft.png");
        }
        else if(direction == 4){
            return ImageLoader.loadCompatibleImage("SwordRight.png");
        }

        return ImageLoader.loadCompatibleImage("SwordDown.png");
    }

    public void move(){
        Rectangle rect = getRectangle();
        if(direction == 1){
            int tempy = (int)rect.getY();
            tempy -= speed;
            rect.move((int)rect.getX(), tempy);
        }
        if(direction == 2){
            int tempy = (int)rect.getY();
            tempy += speed;
            rect.move((int)rect.getX(), tempy);
        }
        if(direction == 3){
            int tempx = (int)rect.getX();
            tempx -= speed;
            rect.move(tempx, (int)rect.getY());
        }
        if(direction == 4){
            int tempx = (int)rect.getX();
            tempx += speed;
            rect.move(tempx, (int)rect.getY());
        }
    }

}
