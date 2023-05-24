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
    private int currentDirection; // 1 = up, 2 = down, 3 = left, 4 = right
    private boolean attacking;
    private int lives;
    private boolean vulnerable;

    public Player(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
        xSpeed = 3;
        ySpeed = 3;
        up = false;
        down = false;
        left = false;
        right = false;
        currentDirection = 2;
        lives = 3;
        vulnerable = true;
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

    public void removeLife(){
        lives--;
    }

    public void setLives(int x){
        lives = x;
    }

    public int getLives(){
        return lives;
    }

    public boolean getVulnerable(){
        return vulnerable;
    }

    public void setVulnerable(boolean x){
        vulnerable = x;
    }

    public void setDirections(boolean u, boolean d, boolean l, boolean r){
        up = u;
        down = d;
        left = l;
        right = r;
    }

    public void setDir(int d){
        currentDirection = d;
    }

    public int getDir(){
        return currentDirection;
    }

    public void draw(Graphics g){
        g.drawImage(getImage(), (int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight(), null);
    }

    public void attack(){   
        attacking = true;
    }

    public void deattack(){
        attacking = false;
    }

    public Image getImage(){
        if(attacking == false){
            if(lives == 3){
                if(up == true && down == false){
                    return ImageLoader.loadCompatibleImage("LinkFacingUp.png");
                }
                else if(left == true && right == false){
                    return ImageLoader.loadCompatibleImage("LinkFacingLeft.png");
                }
                else if(right == true && left == false){
                    return ImageLoader.loadCompatibleImage("LinkFacingRight.png");
                }
                else if(down == true && up == false){
                    return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
                }
                else{
                    if(currentDirection == 1){
                        return ImageLoader.loadCompatibleImage("LinkFacingUp.png");
                    }
                    else if(currentDirection == 2){
                        return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
                    }
                    else if(currentDirection == 3){
                        return ImageLoader.loadCompatibleImage("LinkFacingLeft.png");
                    }
                    else if(currentDirection == 4){
                        return ImageLoader.loadCompatibleImage("LinkFacingRight.png");
                    }
                }
                return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
            }
            if(lives == 2){
                if(up == true && down == false){
                    return ImageLoader.loadCompatibleImage("BlinkFacingUp.png");
                }
                else if(left == true && right == false){
                    return ImageLoader.loadCompatibleImage("BlinkFacingLeft.png");
                }
                else if(right == true && left == false){
                    return ImageLoader.loadCompatibleImage("BlinkFacingRight.png");
                }
                else if(down == true && up == false){
                    return ImageLoader.loadCompatibleImage("BlinkFacingDown.png");
                }
                else{
                    if(currentDirection == 1){
                        return ImageLoader.loadCompatibleImage("BlinkFacingUp.png");
                    }
                    else if(currentDirection == 2){
                        return ImageLoader.loadCompatibleImage("BlinkFacingDown.png");
                    }
                    else if(currentDirection == 3){
                        return ImageLoader.loadCompatibleImage("BlinkFacingLeft.png");
                    }
                    else if(currentDirection == 4){
                        return ImageLoader.loadCompatibleImage("BlinkFacingRight.png");
                    }
                }
                return ImageLoader.loadCompatibleImage("BlinkFacingDown.png");
            }
            if(lives == 1){
                if(up == true && down == false){
                    return ImageLoader.loadCompatibleImage("RinkFacingUp.png");
                }
                else if(left == true && right == false){
                    return ImageLoader.loadCompatibleImage("RinkFacingLeft.png");
                }
                else if(right == true && left == false){
                    return ImageLoader.loadCompatibleImage("RinkFacingRight.png");
                }
                else if(down == true && up == false){
                    return ImageLoader.loadCompatibleImage("RinkFacingDown.png");
                }
                else{
                    if(currentDirection == 1){
                        return ImageLoader.loadCompatibleImage("RinkFacingUp.png");
                    }
                    else if(currentDirection == 2){
                        return ImageLoader.loadCompatibleImage("RinkFacingDown.png");
                    }
                    else if(currentDirection == 3){
                        return ImageLoader.loadCompatibleImage("RinkFacingLeft.png");
                    }
                    else if(currentDirection == 4){
                        return ImageLoader.loadCompatibleImage("RinkFacingRight.png");
                    }
                }
                return ImageLoader.loadCompatibleImage("RinkFacingDown.png");
            }
        }
        else{
            if(lives == 3){
                if(currentDirection == 1){
                    return ImageLoader.loadCompatibleImage("LinkAttackingUp.png");
                }
                else if(currentDirection == 2){
                    return ImageLoader.loadCompatibleImage("LinkAttackingDown.png");
                }
                    else if(currentDirection == 3){
                        return ImageLoader.loadCompatibleImage("LinkAttackingLeft.png");
                    }
                    else if(currentDirection == 4){
                        return ImageLoader.loadCompatibleImage("LinkAttackingRight.png");
                    }
                return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
            }
            if(lives == 2){
                if(currentDirection == 1){
                    return ImageLoader.loadCompatibleImage("BlinkAttackingUp.png");
                }
                else if(currentDirection == 2){
                    return ImageLoader.loadCompatibleImage("BlinkAttackingDown.png");
                }
                    else if(currentDirection == 3){
                        return ImageLoader.loadCompatibleImage("BlinkAttackingLeft.png");
                    }
                    else if(currentDirection == 4){
                        return ImageLoader.loadCompatibleImage("BlinkAttackingRight.png");
                    }
                return ImageLoader.loadCompatibleImage("BlinkFacingDown.png");
            }
            if(lives == 1){
                if(currentDirection == 1){
                    return ImageLoader.loadCompatibleImage("RinkAttackingUp.png");
                }
                else if(currentDirection == 2){
                    return ImageLoader.loadCompatibleImage("RinkAttackingDown.png");
                }
                    else if(currentDirection == 3){
                        return ImageLoader.loadCompatibleImage("RinkAttackingLeft.png");
                    }
                    else if(currentDirection == 4){
                        return ImageLoader.loadCompatibleImage("RinkAttackingRight.png");
                    }
                return ImageLoader.loadCompatibleImage("RinkFacingDown.png");
            }
        }
        return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
    }
}

