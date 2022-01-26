import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GroundHigh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundHigh extends Actor
{
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //Same as ground but at the highest point unless the game is over
        if(Greenfoot.isKeyDown("d") && Player.lost == false && Player.win == false)
        {
            move(-10);
        }
        if(Greenfoot.isKeyDown("a") && Player.lost == false && Player.win == false)
        {
            move(10);
        }
        //When a platform reaches the left end of the screen another is spawned in the same general area
        if(getX() == 0)
        {
            setLocation(getWorld().getWidth() - 1,Greenfoot.getRandomNumber(50) + 250);
        }
    }
}
