import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Orange extends Food
{
    public Orange() {
        super(5);
    }
    
    public void act() {
        drop(8);
    }
    
    public void onDrop() {
        world.startOrangeTimer();
    }
    
    public void onCollect() {
        world.startOrangeTimer();
    }
}
