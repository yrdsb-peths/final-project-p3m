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
    Label titleLabel = new Label("A Platformer(?)", 48);
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
            Instructions gameWorld = new Instructions();
            Greenfoot.setWorld(gameWorld);
        }
        //When the user presses h on the title screen, they will be taken to the highscores
        if(Greenfoot.isKeyDown("h"))
        {
            HighScores gameWorld = new HighScores();
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
        Label start = new Label("Press <space> to start", 50);
        addObject(start, getWidth() / 2, 500);
        Label highScore = new Label("Press <h> to view available highscores", 50);
        addObject(highScore, getWidth() / 2, 550);
    }
}
