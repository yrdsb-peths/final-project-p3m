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
        //An object that moves along the screen unless the game is over
        if(Greenfoot.isKeyDown("d") && Player.lost == false && Player.win == false)
        {
            move(-10);
        }
        if(Greenfoot.isKeyDown("a") && Player.lost == false && Player.win == false)
        {
            move(10);
        }
    }
}
