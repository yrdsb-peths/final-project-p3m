import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 1260x720 cells with a cell size of 1x1 pixels.
        super(1260, 720, 1); 
        prepare();
    }

    public void act()
    {
        //When the user presses space on the title screen, they are taken to the next world
        if(Greenfoot.isKeyDown("enter"))
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
        Label instructions = new Label("The goal of this game is to collect coins until the exit appears and then reaching the ", 40);
        addObject(instructions, getWidth() / 2, 100);
        Label instructions2 = new Label("the exit as fast as possible without falling off the platforms. 'a' and 'd' to move", 40);
        addObject(instructions2, getWidth() / 2, 150);
        Label instructions3 = new Label("left and right, 'space' to jump, 'r' to restart the level, and 't' to return to the title. ", 40);
        addObject(instructions3, getWidth() / 2, 200);
        Label start = new Label("Press <enter> to start", 50);
        addObject(start, getWidth() / 2, 550);
    }
}
