import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Food extends Actor {
    private World world;
    private int value;
    
    public Food(int value) {
        this.value = value;
    }
    
    public void addedToWorld(World world) {
        this.world = world;
    }
    
    public int getValue() {
        return value;
    }
    
    public void drop(int speed) {
        setLocation(getX(), getY() + speed);
        if (getY() >= world.getHeight() - 1) {
            world.removeObject(this);
        }
    }
}
