import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Fruits
{
    private static final GreenfootImage image = new GreenfootImage("images/banana.png");
    
    public Banana(){
        setImage(image);
        points = 40;
    }   
}
