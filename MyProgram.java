import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyProgram extends JPanel implements ActionListener, KeyListener {

    private static Player player = new Player(50, 50, 50, 50); //a rectangle that represents the player
    private Rectangle goal = new Rectangle(); //a rectangle that represents the goal
    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>(); //the array of Enemy objects
    private static ArrayList<Sword> swords = new ArrayList<Sword>();
   
    private boolean up, down, left, right; //booleans that track which keys are currently pressed
    private Timer timer; //the update timer
   
    private int gameWidth = 480; //the width of the game area
    private int gameHeight = 480; //the height of the game area

    private static JLabel dialogLabel;
    private static JFrame frame;
    private static JDialog dialog;
    
    private int currentLevel = 1;
    private int numLevels = 4;

    private boolean attacking;
    private int attackCounter;
    private int vulnerablecounter;
   
    //Sets up the basic GUI for the game
    public static void main(String[] args) {
        frame = new JFrame();
       
        dialog = new JDialog(frame, "Status");
        dialogLabel = new JLabel("");
        dialogLabel.setHorizontalAlignment(JLabel.CENTER);
        dialog.add(dialogLabel);
        dialog.setBounds(125, 125, 100, 70);
        dialog.setVisible(false);
       
        frame.setTitle("Zelda Game");
        frame.setLayout(new BorderLayout());
       
        MyProgram game = new MyProgram();
        frame.add(game, BorderLayout.CENTER);
      
        game.addKeyListener(game);
        frame.addKeyListener(game);
       
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
       
        game.setUpGame();
        // game.enterFullScreen();
    }
   
    //Constructor for the game panel
    public MyProgram() {
         setPreferredSize(new Dimension(gameWidth, gameHeight));
    }
   
    //Method that is called by the timer 30 times per second (roughly)
    //Most games go through states - updating objects, then drawing them
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
   
    //Called every time a key is pressed
    //Stores the down state for use in the update method
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            attacking = true;
            swords.add(new Sword(player.getX(), player.getY(), 30, 30, player.getDir(), 12));
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
            player.setDirections(true, down, left, right);
            player.setDir(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
            player.setDirections(up, true, left, right);
            player.setDir(2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
            player.setDirections(up, down, true, right);
            player.setDir(3);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
            player.setDirections(up, down, left, true);
            player.setDir(4);
        }
    }
   
    //Called every time a key is released
    //Stores the down state for use in the update method
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
            player.setDirections(false, down, left, right);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
            player.setDirections(up, false, left, right);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
            player.setDirections(up, down, false, right);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
            player.setDirections(up, down, left, false);
        }
    }
   
    //Called every time a key is typed
    public void keyTyped(KeyEvent e) {
    }
   
    //Sets the initial state of the game
    //Could be modified to allow for multiple levels
    public void setUpGame() {
           
        enemies.clear();
        
        if(timer != null) {
            timer.stop();
        }
   
        timer = new Timer(1000 / 30, this); //roughly 30 frames per second
        timer.start();
       
        up = down = left = right = attacking = false;
   
        //player = new Rectangle(50, 50, 20, 20);
        //goal = new Rectangle(400, 300, 20, 20);
        //enemies.add(new VerticalEnemy(240,240,30,30,480,5));
        enemies.add(new Moblin(240, 240, 30,30,2,5,480,480));
        enemies.add(new Moblin(240, 240, 30,30,3,5,480,480));
    }
   
    private void enterFullScreen() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphicsEnvironment.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(frame);
            frame.validate();
        }
    }
   
    //The update method does 5 things
    //1 - it has the player move based on what key is currently being pressed
    //2 - it prevents the player from leaving the screen
    //3 - it checks if the player has reached the goal, and if so congratualtes them and restarts the game
    //4 - it checks if any of the Enemy objects are touching the player, and if so notifies the player of their defeat and restarts the game
    //5 - it tells each of the Enemy objects to update()
    public void update() {
        if(attacking){
            player.attack();
            attackCounter++;
            if(attackCounter == 5){
                attackCounter = 0;
                attacking = false;
                player.deattack();
            }
        }
        else if(up) {
            player.setY((int)(player.getRectangle().getY()-3));
        }
        if(down) {
            player.setY((int)(player.getRectangle().getY()+3));
        }
        if(left) {
            player.setX((int)(player.getRectangle().getX()-3));
        }
        if(right) {
            player.setX((int)(player.getRectangle().getX()+3));
        }

       
        if(player.getX() < 0) {
            player.setX(0);
        }
        else if(player.getX() + player.getRectangle().getWidth() > gameWidth) {
            player.setX((int)(gameWidth - player.getRectangle().getWidth()));
        }
       
        if(player.getY() < 0) {
            player.setY(0);
        }
        else if(player.getY() + player.getRectangle().getHeight() > gameHeight) {
            player.setY((int)(gameHeight - player.getRectangle().getHeight()));
        }
       
        for(int i = 0; i < enemies.size(); i++) {
            if(enemies.get(i) == null)
                continue;
       
            if(enemies.get(i).intersects(player.getRectangle()) && player.getVulnerable()) {
                player.removeLife();
                player.setVulnerable(false);
                if(player.getLives() == 0){
                    onLose();
                }
            }

            if(player.getVulnerable() == false){
                vulnerablecounter++;
                if(vulnerablecounter == 30){
                    vulnerablecounter = 0;
                    player.setVulnerable(true);
                }
            }
           
            enemies.get(i).move();
        }

        for(int i = 0; i < swords.size(); i++) {
            if(swords.get(i) == null){
                continue;
            }
            swords.get(i).move();
            for(int k = 0; k < enemies.size(); k++){
                if(enemies.get(k) == null){
                    continue;
                }
                if(enemies.get(k).intersects(swords.get(i).getRectangle())){
                    enemies.remove(k);
                    swords.remove(i);
                }
            }
        }
       
    }
   
    //The paint method does 3 things
    //1 - it draws a white background
    //2 - it draws the player in blue
    //3 - it draws the goal in green
    //4 - it draws all the Enemy objects
    public void paint(Graphics g) {
        g.setColor(new Color(230,230,230));
        g.fillRect(0, 0, gameWidth, gameHeight);
   
        g.setColor(Color.BLUE);
        g.drawImage(player.getImage(), player.getX(), player.getY(), (int)player.getRectangle().getWidth(), (int)player.getRectangle().getHeight(), null);
        //g.fillRect(player.getX(), player.getY(), (int)player.getRectangle().getWidth(), (int)player.getRectangle().getHeight());
       
        g.setColor(Color.GREEN);
        g.fillRect(goal.x, goal.y, goal.width, goal.height);
       
        for(Enemy e: enemies) {
            if(e == null)
                continue;
            e.draw(g);
        }

        for(Sword s: swords){
            if(s == null){
                continue;
            }
            g.drawImage(s.getImage(), s.getX(), s.getY(), (int)s.getRectangle().getWidth(), (int)s.getRectangle().getHeight(), null);
        }
    }
   
    private void onWin() {
        currentLevel++;
        if(currentLevel > numLevels){
            createDialog("You Won!",2000);
            currentLevel = 1;
        }
        setUpGame();
    }
   
    private void onLose() {
        createDialog("You Lost", 2000);
        setUpGame();
    }
   
    // Sets visible a Pseudo-dialog that removes itself after a fixed time interval
    // Uses a thread to not block the rest of the program
    //
    // @param: message: String -> The message that will appear on the dialog
    // @param: delay: int -> How long (in milliseconds) that Dialog is visible
    private void createDialog(String message, int delay) {
        dialogLabel.setText(message);
        dialog.setVisible(true);
        frame.requestFocus();
       
        Thread thread = new Thread(() -> {
            try {
                // Show pop up for [delay] milliseconds
                Thread.sleep(delay);
            } catch(Exception e) {
                System.out.println("Thread failed :(");
                dialog.setVisible(false);
                frame.requestFocus();
            }
            // End of 3 seconds
            // Close the pop up
            dialog.setVisible(false);
            frame.requestFocus();
        });
        thread.start();
    }
    
    public static ArrayList<Enemy> getEnemies(){
        return enemies;
    }
    
    public static Rectangle getPlayer(){
        return player.getRectangle();
    }

    public Image getPlayerImage(){
        if(up){
            return ImageLoader.loadCompatibleImage("LinkFacingUp.png");
        }
        else if(down){
            return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
        }
        else if(left){
            return ImageLoader.loadCompatibleImage("LinkFacingLeft.png");
        }
        else if(right){
            return ImageLoader.loadCompatibleImage("LinkFacingRight.png");
        }
        else{
            return ImageLoader.loadCompatibleImage("LinkFacingDown.png");
        }
    }
}