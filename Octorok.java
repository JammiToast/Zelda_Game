import java.awt.*;

public class Octorok extends Enemy{
    private int direction;
    private int x2;
    private int y2;

    public Octorok(int x, int y, int w, int h, int dir){
        super(x,y,w,h);
        x2 = x;
        y2 = y;
        direction = dir;

    }

    public Color getColor(){
        return Color.RED;
    }

    public void move(){
        super.getRectangle().move(x2, y2);
    }

    public int getDirection(){
        return direction;
    }

    public void draw(Graphics g){
        g.drawImage(getImage(), (int)getRectangle().getX(), (int)getRectangle().getY(), (int)getRectangle().getWidth(), (int)getRectangle().getHeight(), null);
    }

    public Image getImage(){
        if(direction == 1){
            return ImageLoader.loadCompatibleImage("OctorokUp.png");
        }
        if(direction == 2){
            return ImageLoader.loadCompatibleImage("OctorokDown.png");
        }
        if(direction == 3){
            return ImageLoader.loadCompatibleImage("OctorokLeft.png");
        }
        if(direction == 4){
            return ImageLoader.loadCompatibleImage("OctorokRight.png");
        }
        return ImageLoader.loadCompatibleImage("OctorokUp.png");
    }

    public boolean isOctorok(){
        return true;
    }

}
