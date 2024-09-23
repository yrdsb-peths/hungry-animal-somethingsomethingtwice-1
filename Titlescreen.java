import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Titlescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titlescreen extends World
{
    MyWorld newWorld;
    
    public Titlescreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        newWorld = new MyWorld();
        prepare();
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(newWorld);
    }
    
    private void prepare()
    {
        Label label = new Label("Hungry Elephant", 64);
        addObject(label,35,69);
        label.setLocation(221,63);
        Label label2 = new Label("Use arrow keys to move!", 32);
        addObject(label2,42,134);
        label2.setLocation(168,118);
        Label label3 = new Label("Collect food and don't let them drop!", 32);
        addObject(label3,35,168);
        label3.setLocation(239,153);
        TitlescreenHero titlescreenHero = new TitlescreenHero();
        addObject(titlescreenHero,82,298);
        titlescreenHero.setLocation(74,327);
        Label label4 = new Label("Press space to start!", 32);
        addObject(label4,233,261);
        label4.setLocation(448,347);
    }
}
