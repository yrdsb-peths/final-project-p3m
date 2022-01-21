import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Title Screen.
 * 
 * @author Jo 
 * @version 11/1/2021
 */
public class Title extends World
{
    //Creates a label to serve as the title of the game 
    Label titleLabel = new Label("p", 48);
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 1260x720 cells with a cell size of 1x1 pixels.
        super(1260, 720, 1); 
        //Adds the title into the world
        addObject(titleLabel, getWidth() / 2, -getHeight() + 850);
        prepare();
    }

    public void act()
    {
        //When the user presses space on the title screen, they are taken to the next world
        if(Greenfoot.isKeyDown("space"))
        {
            Level gameWorld = new Level();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Placements for the objects on the screen
        Label label = new Label("Press <space> to start", 50);
        addObject(label, getWidth() / 2, 550);
    }
}
