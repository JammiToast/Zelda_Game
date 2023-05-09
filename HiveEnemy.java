import java.util.*;
import java.awt.*;

public class HiveEnemy extends Enemy{
    
    private int spawnRate;
    private int currentTick;
    
    public HiveEnemy(int x,int y,int w,int h, int s){
        super(x,y,w,h);
        spawnRate = s;
        currentTick = 0;
    }
    
    public void move(){
        currentTick++;
        Rectangle rect = getRectangle();
        if(currentTick == spawnRate){
            MyProgram.getEnemies().add(new StalkerEnemy((int)rect.getX(),(int)rect.getY(),10,10, MyProgram.getPlayer()));
            currentTick = 0;
        }
    }
    
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("hive.png");
    }
    
    public Color getColor(){
        return Color.ORANGE;
    }
}