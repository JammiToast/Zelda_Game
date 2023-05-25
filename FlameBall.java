import java.awt.*;

public class FlameBall extends Enemy{
    private int direction;
    private int speed;
    private int screenHeight;
    private int screenWidth;

    public FlameBall(int x, int y, int w, int h, int dir, int s, int sH, int sW){
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

    public Image getImage(){
        return ImageLoader.loadCompatibleImage("flameball.png");
    }

    public void draw(Graphics g){
        g.drawImage(getImage(), (int)getRectangle().getX(), (int)getRectangle().getY(), (int)getRectangle().getWidth(), (int)getRectangle().getHeight(), null);
    }
    




}
