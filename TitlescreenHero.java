import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitlescreenHero extends Actor
{
    private int scale = 2;
    
    public TitlescreenHero() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() * scale, image.getHeight() * scale);
    }
}
