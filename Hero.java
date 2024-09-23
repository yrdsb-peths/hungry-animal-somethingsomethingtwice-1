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
    private boolean isLeft = false;
    private int scale = 2;
    
    GreenfootImage[] idleSprites = new GreenfootImage[1];
    GreenfootImage[] idleSpritesLeft = new GreenfootImage[1];
    public Hero() {
        idleSprites[0] = getImage();
        idleSprites[0].scale(idleSprites[0].getWidth() * scale, idleSprites[0].getHeight() * scale);
        
        idleSpritesLeft[0] = new GreenfootImage(idleSprites[0]);
        idleSpritesLeft[0].mirrorHorizontally();
    }
    
    public void act() {
        int movement = 0;
        if (Greenfoot.isKeyDown("right"))
            movement++;
        if (Greenfoot.isKeyDown("left")) {
            movement--;
        }
        move(movement * speed);
        
        if (movement != 0) {
            if (movement > 0)
                setImage(idleSprites[0]);
            else
                setImage(idleSpritesLeft[0]);
        }
       
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
