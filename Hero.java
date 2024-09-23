import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our hero, who collects apples.
 * 
 * @author Ethan
 * @version 18/9/2024
 */
public class Hero extends Actor
{
    private int speed = 8;
    private int scale = 2;
    
    public Hero() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() * scale, image.getHeight() * scale);
    }
    
    public void act() {
       int movement = 0;
       if (Greenfoot.isKeyDown("right"))
           movement++;
       if (Greenfoot.isKeyDown("left"))
           movement--;
       move(movement * speed);
       
       collideWithFood();
    }
    
    private void collideWithFood() {
        Actor obj = getOneIntersectingObject(Food.class);
        if (obj != null) {
            Food food = (Food) obj;
            MyWorld world = (MyWorld) getWorld();
            world.incrementScore(food.getValue());
            world.removeObject(food);
            world.createFood();
        }
    }
}
