import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //Moves the coins on the screen
        if(Greenfoot.isKeyDown("d"))
        {
            move(-10);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(10);
        }
        //If the coin reaches the left end of the screen it is removed
        if(getX() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
