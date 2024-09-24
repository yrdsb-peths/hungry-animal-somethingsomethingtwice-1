import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int score = 0;
    Label label;
    SimpleTimer orangeTimer;
    boolean orangeSpawned = false;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        // Set paint order
        setPaintOrder(Label.class, Hero.class, Food.class);
        
        label = new Label(score, 32);
        addObject(label, 300, 32);
        
        Hero hero = new Hero();
        addObject(hero, 300, 400 - 64);
        createFood();
        
        orangeTimer = new SimpleTimer();
        orangeTimer.mark();
    }
    
    public void act() {
        if (!orangeSpawned && orangeTimer.millisElapsed() > 6000) {
            int x = Greenfoot.getRandomNumber(600);
            addObject(new Orange(), x, 0);
            orangeSpawned = true;
        }
    }
    
    public void createFood() {
        int x = Greenfoot.getRandomNumber(600);
        addObject(new Apple(), x, 0);
    }
    
    public void startOrangeTimer() {
        orangeSpawned = false;
        orangeTimer.mark();
    }
    
    public void incrementScore(int score) {
        this.score += score;
        label.setValue(this.score);
    }
}
