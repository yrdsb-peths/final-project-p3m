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
    boolean win = false;
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
        
        secondLevel();
        
        lose();
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
    
    public void lose()
    {
        Actor character = (Actor) getWorld().getObjects(Player.class).get(0);
        if(character.getY() == 719 && Greenfoot.isKeyDown("right"))
        {
            Level Level = (Level) getWorld();
            String loss = "You lost. Press R to restart";
            Level.display(loss);
        }
    }
    
    public void restart()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            Greenfoot.setWorld(new Level());
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
        //Picking up a coin adds 1 to the visual counter
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
    //If the player touches the entrance to the next level, they are taken to the next level
    public void secondLevel()
    {
        Actor EndLevel = getOneIntersectingObject(EndLevel.class);
        if(EndLevel != null)
        {
            getWorld().removeObject(EndLevel);
            double time = (double)Level.timer.millisElapsed()/1000;
            Level Level = (Level) getWorld();
            String result = "You Won In " + Double.toString(time) + " seconds";
            Level.display(result);
            //Greenfoot.setWorld(new Level2());
        }
    }
}
