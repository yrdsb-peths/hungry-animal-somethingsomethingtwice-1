import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public void onCollect() {
        world.createFood();
    }
}
