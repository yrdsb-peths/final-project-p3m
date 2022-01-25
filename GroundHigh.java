import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GroundHigh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundHigh extends Actor
{
    public GroundHigh()
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
        //Same as ground but at the highest point
        if(Greenfoot.isKeyDown("d"))
        {
            move(-10);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(10);
        }
        if(getX() == 0)
        {
            setLocation(getWorld().getWidth() - 1,Greenfoot.getRandomNumber(50) + 250);
        }
    }
}
