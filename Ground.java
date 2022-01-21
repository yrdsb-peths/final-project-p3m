import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    //Makes the object larger
    public Ground()
    {
        getImage().scale(getImage().getWidth() * 6,getImage().getHeight() * 2);
    }
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //Ground moves along the screen for the player to land on
        if(Greenfoot.isKeyDown("right"))
        {
            move(-10);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(10);
        }
        //When a platform reaches the left end of the screen another is spawned in the same general area
        if(getX() == 0)
        {
            setLocation(getWorld().getWidth() - 1,Greenfoot.getRandomNumber(100) + 550);
        }
    }
}
