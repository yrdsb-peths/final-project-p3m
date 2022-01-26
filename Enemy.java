import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Moves the enemy across the screen
        move(-10);
        //If the enemy reaches the edge of the screen it is removed
        if(getX() == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
