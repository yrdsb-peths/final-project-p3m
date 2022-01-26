import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 0;
    private int acceleration = 1;
    private int jumpHeight = -20;
    private int coins = 0;
    //Prevents user from winning multiple times in one trun
    public static boolean win = false;
    //Allows the world to stop if the player loses
    public static boolean lost = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move();
        
        isFalling();
        
        grabCoin();
        
        restart();
        
        exitToTitle();
        
        lose();
        
        touchEnemy();
        
        win();
        
        easyWin();
    }
    //When the player falls, they should slowly fall faster the farther they fall
    private void fall()
    {
        setLocation(getX(), getY() + speed);
        speed = speed + acceleration;
    }
    //Allows the player to jump when on a platform
    public void move()
    {
        if(Greenfoot.isKeyDown("space") && (onGround() == true) || Greenfoot.isKeyDown("space") && onGroundMid() == true || Greenfoot.isKeyDown("space") && onGroundHigh() == true)
        {
            speed = jumpHeight;
            if(speed > 5)
                 speed = 5;
            fall();
        }
    }
    //If the player falls off the platforms then they are prompted with a screen
    //that informs them so and tells them to restart
    public void lose()
    {
        Actor character = (Actor) getWorld().getObjects(Player.class).get(0);
        if(character.getY() == 719 && Greenfoot.isKeyDown("d") || character.getY() == 719 && Greenfoot.isKeyDown("a"))
        {
            Level Level = (Level) getWorld();
            String loss = "You lost. Press R to restart";
            Level.display(loss, Level.getWidth()/2, Level.getHeight()/2);
            lost = true;
        }
    }
    public void touchEnemy()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if(enemy != null)
        {
            Level Level = (Level) getWorld();
            String loss = "You lost. Press R to restart";
            Level.display(loss, Level.getWidth()/2, Level.getHeight()/2);
            getWorld().removeObject(enemy);
            lost = true;
        }
    }
    //Sets the world at the beginning if the player presses r
    public void restart()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            Greenfoot.setWorld(new Level());
            lost = false;
        }
    }
    //Takes the player back to the title screen
    public void exitToTitle()
    {
        if(Greenfoot.isKeyDown("t"))
        {
            Greenfoot.setWorld(new Title());
        }
    }
    //If the key is pressed then the user "wins", intended to test code based around completion
    public void easyWin()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            win = true;
            //Displays how much time it took to win
            double time = (double)Level.timer.millisElapsed()/1000;
            Level Level = (Level) getWorld();
            String result = "You Won In " + Double.toString(time) + " seconds";
            Level.display(result, Level.getWidth()/2, Level.getHeight()/2);
            //Adds score to both high score and recent score
            HighScores.stack.push(time);
            HighScores.arr.add(time);
        }
    }
    //Checks if the player is standing on a platform
    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        return under != null;
    }
    boolean onGroundMid()
    {
        Actor underMid = getOneObjectAtOffset(0, getImage().getHeight() / 2, GroundMid.class);
        return underMid != null;
    }
    boolean onGroundHigh()
    {
        Actor underHigh = getOneObjectAtOffset(0, getImage().getHeight() / 2, GroundHigh.class);
        return underHigh != null;
    }
    //Causes the player to fall if they are not on the ground
    public void isFalling()
    {
        if(onGround() == false || onGroundMid() == false || onGroundHigh() == false)
        {
            fall();
        }
        if(onGround() == true || onGroundMid() == true || onGroundHigh() == true)
        {
            speed = 0;
        }
    }
    //If the player touches a coin the coin disappears
    public void grabCoin()
    {
        Actor coin = getOneIntersectingObject(Coin.class);
        Level Level = (Level) getWorld();
        //Picking up a coin removes the coin from the screen and adds 1 to the visual counter
        if(coin != null)
        {
            getWorld().removeObject(coin);
            coins++;
            Level.increaseScore();
        }
        //Once the player collects 10 coins, the entrance to the next level appears
        if(coins == 10 && win == false)
        {
            getWorld().addObject(new EndLevel(), 1250, 400);
            win = true;
        }
    }
    //If the player touches the end object, the player "wins"
    public void win()
    {
        Actor EndLevel = getOneIntersectingObject(EndLevel.class);
        if(EndLevel != null)
        {
            getWorld().removeObject(EndLevel);
            //Displays how much time it took to win
            double time = (double)Level.timer.millisElapsed()/1000;
            Level Level = (Level) getWorld();
            String result = "You Won In " + Double.toString(time) + " seconds";
            Level.display(result, Level.getWidth()/2, Level.getHeight()/2);
            //Adds score to both high score and recent score
            HighScores.stack.push(time);
            HighScores.arr.add(time);
        }
    }
}
