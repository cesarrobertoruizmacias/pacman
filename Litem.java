import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Litem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Litem extends Items
{
    private static final GreenfootImage image = new GreenfootImage("images/superitem.png");
    
    public Litem(){
        setImage(image);
        points=50;
    }    
}
