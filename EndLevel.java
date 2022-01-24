import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndLevel extends Actor
{
    /**
     * Act - do whatever the EndLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //An object that moves along the screen
        if(Greenfoot.isKeyDown("right"))
        {
            move(-10);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(10);
        }
    }
}
