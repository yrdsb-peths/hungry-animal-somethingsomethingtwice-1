import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Food
{
    public Apple() {
        super(1);
    }
    
    public void act() {
        drop(3);
    }
    
    public void onDrop() {
        GameOver gameover = new GameOver();
        world.addObject(gameover, 300, 200);
    }
}
