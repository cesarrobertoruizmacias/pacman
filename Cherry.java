import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cherry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cherry extends Fruits
{
    private static final GreenfootImage image = new GreenfootImage("images/cherries.png");
    
    public Cherry(){
        setImage(image);
        points = 30;
    }   
}
