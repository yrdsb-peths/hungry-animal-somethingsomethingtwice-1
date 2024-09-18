import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our hero, who collects apples.
 * 
 * @author Ethan
 * @version 18/9/2024
 */
public class Hero extends Actor
{
    int speed = 8;
    
    public void act()
    {
       int movement = 0;
       if (Greenfoot.isKeyDown("right"))
           movement++;
       if (Greenfoot.isKeyDown("left"))
           movement--;
       move(movement * speed);
    }
}
