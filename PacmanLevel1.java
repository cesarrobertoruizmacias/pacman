import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanLevel1 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanLevel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        map();
        items();
        huecos();
        chacters();
        
        text();
        
    }
    public void map(){
        for(int x = 0; x < 1080; x+=72){
            this.addObject(new Wall(), x, 0);
            this.addObject(new Wall(), x, 800);
        }
        for(int y=0; y<355; y+=56){
            this.addObject(new Wall(), 0, y);
            this.addObject(new Wall(), 1000, y);
        }
        for(int y=475; y<800; y+=56){
            this.addObject(new Wall(), 0, y);
            this.addObject(new Wall(), 1000, y);
        }
        for(int x=400,y=560,z=400; x<600 && y<620 && z<620; x+=72){
            this.addObject(new WallH(), x, 350);
            this.addObject(new WallH(), y+=72, 350);
            this.addObject(new WallH(), z+=72, 450);
            
        }
        for(int x = 400; x < 620; x+=72){
            this.addObject(new WallH(), x, 450);
        }
        for(int y=380; y<480; y+=55){
            this.addObject(new WallV(), 380, y);
            this.addObject(new WallV(), 650, y);
        }
    }
    public void huecos(){
        addObject(new HuecoDerecha(), 998, 401);
        addObject(new HuecoIzquierda(), 0, 401);
    }
    public void chacters(){
        addObject(new Pacman(), 500, 250);
        addObject(new Red(), 230, 200);
        
    }
    public void items(){
        for(int x=70;x<950;x+=150){
            addObject(new Sitem(), x,80);
            addObject(new Sitem(), x,730);
        }
        addObject(new Litem(), 215,394);
        addObject(new Litem(), 759,396);
        addObject(new Banana(), 500,400);
        addObject(new Cherry(), 500,650);
    }
    public void text(){
        addObject(new Point(), 34,781);
    }
}
