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
    }
    
    public void createFood() {
        Food food = null;
        int rand = Greenfoot.getRandomNumber(1);
        
        if (rand == 0) {
            food = new Apple();
        }
        
        if (food != null) {
            int x = Greenfoot.getRandomNumber(600);
            addObject(food, x, 0);
        }
    }
    
    public void incrementScore(int score) {
        this.score += score;
        label.setValue(this.score);
    }
}
