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
    private double spriteIndex = 0.0;
    private double spriteWrap = 0.0;
    private boolean isLeft = false;
    
    private GreenfootImage[][] idleSprites = new GreenfootImage[8][2];
    private GreenfootImage[][] walkSprites = new GreenfootImage[8][2];
    private GreenfootImage[][] currentSprite = null;
    private GreenfootSound collectSound;
    public Hero() {
        for (int i = 0; i < idleSprites.length; i++) {
            idleSprites[i][0] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            idleSprites[i][0].scale(idleSprites[i][0].getWidth() * scale, idleSprites[i][0].getHeight() * scale);
            idleSprites[i][1] = new GreenfootImage(idleSprites[i][0]);
            idleSprites[i][1].mirrorHorizontally();
        }
        
        for (int i = 0; i < walkSprites.length; i++) {
            walkSprites[i][0] = new GreenfootImage("elephant_walk/walk" + i + ".png");
            walkSprites[i][0].scale(walkSprites[i][0].getWidth() * scale, walkSprites[i][0].getHeight() * scale);
            walkSprites[i][1] = new GreenfootImage(walkSprites[i][0]);
            walkSprites[i][1].mirrorHorizontally();
        }
        
        collectSound = new GreenfootSound("elephantcub.mp3");
    }
    
    public void act() {
        if (getWorld().getObjects(GameOver.class).size() <= 0) {
            int movement = 0;
            if (Greenfoot.isKeyDown("right"))
                movement++;
            if (Greenfoot.isKeyDown("left")) {
                movement--;
            }
            move(movement * speed);
            
            if (movement != 0) {
                if (movement > 0)
                    isLeft = false;
                else
                    isLeft = true;
                switchSprite(walkSprites);
            } else
                switchSprite(idleSprites);
           
            collideWithFood();
        }
    }
    
    private void collideWithFood() {
        Actor obj = getOneIntersectingObject(Food.class);
        if (obj != null) {
            Food food = (Food) obj;
            MyWorld world = (MyWorld) getWorld();
            world.incrementScore(food.getValue());
            world.removeObject(food);
            world.createFood();
            collectSound.play();
        }
    }
    
    private void switchSprite(GreenfootImage[][] newSprite) {
        if (currentSprite != newSprite) {
            currentSprite = newSprite;
            spriteIndex = 0;
            spriteWrap = newSprite.length;
        } else {
            spriteIndex = (spriteIndex + 0.35) % spriteWrap;
        }
        
        setImage(newSprite[(int) spriteIndex][isLeft ? 1 : 0]);
    }
}
