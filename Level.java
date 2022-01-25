import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    private int score = 0;
    private int time = 0;
    public static SimpleTimer timer = new SimpleTimer();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1260, 720, 1); 
        prepare();
        timer.mark();
    }
    
    public void act()
    {
        //Displays the number of coins collected out of the total of 10
        showText(score + "/10", 100, 20);
        //Spawns coins when the player is moving through the world to prevent clumps
        if(Greenfoot.getRandomNumber(100) <= 2 && Greenfoot.isKeyDown("d"))
        {
            addObject(new Coin(), getWidth() - 1, Greenfoot.getRandomNumber(360) + 200);
        }
    }
    //Score represents number of coins so everytime one is grabbed the number increases
    public void increaseScore()
    {
        score = score + 1;
    }
    
    public void display(String text, int x, int y)
    {
        int size = getWidth() / 12;
        Label label = new Label(text, size);
        label.setFillColor(Color.YELLOW);
        addObject(label, x, y);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,322,477);
        ground.setLocation(102,533);
        removeObject(ground);
        addObject(ground,124,570);
        ground.setLocation(93,605);
        Ground ground2 = new Ground();
        addObject(ground2,385,502);
        ground2.setLocation(443,511);
        Ground ground3 = new Ground();
        addObject(ground3,716,400);
        ground3.setLocation(683,648);
        Ground ground4 = new Ground();
        addObject(ground4,907,379);
        ground4.setLocation(964,458);
        Player player = new Player();
        addObject(player,85,573);
        player.setLocation(97,579);
        player.setLocation(89,588);
        Ground ground5 = new Ground();
        addObject(ground5,1099,573);
        Ground ground6 = new Ground();
        addObject(ground6,511,345);
        Ground ground7 = new Ground();
        addObject(ground7,123,254);
        Ground ground8 = new Ground();
        addObject(ground8,935,278);
        Ground ground9 = new Ground();
        addObject(ground9,1241,400);
        ground3.setLocation(700,685);
        ground5.setLocation(1153,616);
        ground4.setLocation(900,503);
        ground6.setLocation(622,342);
        ground7.setLocation(236,293);
        ground.setLocation(169,606);
        ground2.setLocation(475,500);
        ground.setLocation(229,608);
        player.setLocation(211,577);
        removeObject(ground2);
        removeObject(ground7);
        removeObject(ground6);
        removeObject(ground4);
        removeObject(ground8);
        removeObject(ground9);
        GroundMid groundMid = new GroundMid();
        addObject(groundMid,249,408);
        groundMid.setLocation(234,406);
        groundMid.setLocation(142,430);
        GroundMid groundMid2 = new GroundMid();
        addObject(groundMid2,401,367);
        groundMid2.setLocation(530,456);
        groundMid2.setLocation(513,451);
        GroundMid groundMid3 = new GroundMid();
        addObject(groundMid3,842,387);
        groundMid3.setLocation(830,380);
        groundMid3.setLocation(808,356);
        GroundMid groundMid4 = new GroundMid();
        addObject(groundMid4,1113,426);
        groundMid4.setLocation(1094,419);
        GroundMid groundMid5 = new GroundMid();
        addObject(groundMid5,807,474);
        groundMid5.setLocation(840,504);
        groundMid4.setLocation(1077,415);
        groundMid2.setLocation(447,459);
        groundMid5.setLocation(715,506);
        groundMid4.setLocation(1112,422);
        GroundHigh groundHigh = new GroundHigh();
        addObject(groundHigh,235,285);
        GroundHigh groundHigh2 = new GroundHigh();
        addObject(groundHigh2,524,215);
        groundHigh2.setLocation(525,231);
        GroundHigh groundHigh3 = new GroundHigh();
        addObject(groundHigh3,978,235);
        GroundHigh groundHigh4 = new GroundHigh();
        addObject(groundHigh4,1134,265);
        groundHigh3.setLocation(856,205);
        groundMid3.setLocation(735,349);
        groundHigh2.setLocation(496,251);
        groundHigh.setLocation(311,324);
        groundHigh.setLocation(313,318);
        groundMid2.setLocation(446,415);
        groundMid5.setLocation(649,530);
        groundMid3.setLocation(795,394);
        groundHigh.setLocation(256,306);
        groundHigh2.setLocation(536,262);
        groundHigh.setLocation(330,349);
        groundHigh3.setLocation(655,337);
        groundHigh4.setLocation(948,294);
        ground5.setLocation(942,602);
        groundHigh.setLocation(313,316);
        groundHigh2.setLocation(553,244);
        groundHigh3.setLocation(715,303);
        groundMid3.setLocation(799,421);
        groundMid5.setLocation(609,538);
        ground5.setLocation(970,609);
    }
}
