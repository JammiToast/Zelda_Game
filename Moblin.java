 import java.awt.*;

public class Moblin extends Enemy{
    private int direction; // 1 up, 2 down, 3 left, 4 right
    private int speed;
    private int screenHeight;
    private int screenWidth;

    public Moblin(int x, int y, int w, int h, int dir, int s, int sH, int sW){
        super(x,y,w,h);
        direction = dir;
        speed = s;
        screenHeight = sH;
        screenWidth = sW;
    }

    public Color getColor(){
        return Color.RED;
    }

    public int getSpeed(){
        return speed;
    }

    public void setDirection(int d){
        direction = d;
    }

    public void move(){
        Rectangle rect = getRectangle();
        if(direction == 2){
            int tempy = (int)rect.getY();
            tempy -= speed;
            rect.move((int)rect.getX(), tempy);
            if(rect.getY() < 0) {
                direction = 1;
            }
        }
        if(direction == 1){
            int tempy = (int)rect.getY();
            tempy += speed;
            rect.move((int)rect.getX(), tempy);
            if(rect.getY() + rect.getHeight() > screenHeight) {
                direction = 2;
            }
        }
        if(direction == 3){
            int tempx = (int)rect.getX();
            tempx += speed;
            rect.move(tempx, (int)rect.getY());
            if(rect.getX() + rect.getWidth() > screenWidth) {
                direction = 4;
            }
        }
        if(direction == 4){
            int tempx = (int)rect.getX();
            tempx -= speed;
            rect.move(tempx, (int)rect.getY());
            if(rect.getX() < 0) {
                direction = 3;
            }
        }
    }

    public void draw(Graphics g){
        Rectangle rect = getRectangle();
        g.drawImage(getImage(), (int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight(), null);
    }

    public Image getImage(){
        if(direction == 2){
            return ImageLoader.loadCompatibleImage("MoblinUp.png");
        }
        if(direction == 1){
            return ImageLoader.loadCompatibleImage("MoblinDown.png");
        }
        if(direction == 4){
            return ImageLoader.loadCompatibleImage("MoblinLeft.png");
        }
        if(direction == 3){
            return ImageLoader.loadCompatibleImage("MoblinRight.png");
        }
        return ImageLoader.loadCompatibleImage("MoblinDown.png");
    }

}
