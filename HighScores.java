import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;
/**
 * Write a description of class HighScores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScores extends World
{
    public static StackOfDoubles stack = new StackOfDoubles();
    public static ArrayList<Double> arr = new ArrayList();
    /**
     * Constructor for objects of class HighScores.
     * 
     */
    public HighScores()
    {    
        // Create a new world with 1260x720 cells with a cell size of 1x1 pixels.
        super(1260, 720, 1); 
        //If the arraylist is not empty then the top scores are displayed
        if(arr.size() >= 1)
        {
            Utilities.quicksort(arr, 0, arr.size() - 1);
            
            double stackTemp = stack.pop();
            stack.push(stackTemp);
            
            String recentScoreTime = "" + stackTemp;
            String highScoreTime = "" + arr.get(0);
            
            Label recentScoreHeader = new Label("Recent Scores", 40);
            Label highScoreHeader = new Label("High Scores", 40);
            
            Label recentScore = new Label(recentScoreTime, 40);
            Label highScore = new Label(highScoreTime, 40);
            
            addObject(recentScoreHeader, getWidth() / 4, 100);
            addObject(highScoreHeader, getWidth() / 4 * 3, 100);
            
            addObject(recentScore, getWidth() / 4, 150);
            addObject(highScore, getWidth() / 4 * 3, 150);
            //
            if(arr.size() >= 2)
            {
                double stackTemp2 = stack.pop();
                stack.push(stackTemp2);
                
                String recentScoreTime2 = "" + stackTemp2;
                String highScoreTime2 = "" + arr.get(1);
                
                Label recentScore2 = new Label(recentScoreTime2, 40);
                Label highScore2 = new Label(highScoreTime2, 40);
                
                addObject(recentScore2, getWidth() / 4, 200);
                addObject(highScore2, getWidth() / 4 * 3, 200);
                if(arr.size() >= 3)
                {
                    double stackTemp3 = stack.pop();
                    stack.push(stackTemp3);
                    
                    String recentScoreTime3 = "" + stackTemp3;
                    String highScoreTime3 = "" + arr.get(2);
                    
                    Label recentScore3 = new Label(recentScoreTime3, 40);
                    Label highScore3 = new Label(highScoreTime3, 40);
                    
                    addObject(recentScore3, getWidth() / 4, 250);
                    addObject(highScore3, getWidth() / 4 * 3, 250);
                }
            }
        }
        //If the arraylist is empty then the player is told that there are no current records
        if(arr.size() == 0)
        {
            Label highScore = new Label("No completed games in current session", 40);
            addObject(highScore, getWidth() / 2, 100);
        }
        Label backToTitle = new Label("Press <t> to return to the title screen", 40);
        
        addObject(backToTitle, getWidth() / 2, 550);
    }
    
    public void act()
    {
        //If the user presses space then they return to the title screen
        if(Greenfoot.isKeyDown("t"))
        {
            Title gameWorld = new Title();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
