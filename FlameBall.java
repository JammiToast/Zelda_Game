import java.awt.*;

public class FlameBall extends Moblin{

    public FlameBall(int x, int y, int w, int h, int dir, int s, int sH, int sW){
        super(x,y,w,h,dir,s,sH,sW);
    }

    public Image getImage(){
        return ImageLoader.loadCompatibleImage("flameball.png");
    }

    public void draw(Graphics g){
        g.drawImage(getImage(), (int)getRectangle().getX(), (int)getRectangle().getY(), (int)getRectangle().getWidth(), (int)getRectangle().getHeight(), null);
    }
    




}
