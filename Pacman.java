import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int OFFSET = 5;
    private static final int INITIAL_LIFES = 3;
    private static final int INITIAL_POINTS = 0;
    private int lifes;
    private int points;
    private int currentImage;
    private int counter;
    private int dir=0;

    public Pacman()
    {
        lifes = INITIAL_LIFES;
        points = INITIAL_POINTS;
        setImage("images/pacman-close.png");
    }

    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveMouth();
        handleDirection();
        collisions();
        teletrasporte();
        eatItems();
    }   

    public void handleDirection(){
        int x = getX();
        int y = getY();

        if(Greenfoot.isKeyDown("right")){
            setLocation(x + OFFSET, y);
            turnTowards(getWorld().getWidth(), getY());
            dir=3;
        }
        else if(Greenfoot.isKeyDown("left")){
            setLocation(x - OFFSET, y);
            turnTowards(0, getY());
            dir=2;
        }
        else if(Greenfoot.isKeyDown("down")){
            setLocation(x, y + OFFSET);
            turnTowards(getX(), getWorld().getHeight());
            dir=1;
        }
        else if(Greenfoot.isKeyDown("up")){
            setLocation(x, y - OFFSET);
            turnTowards(getX(), 0);
            dir=0;
        }
    }

    public void moveMouth(){
        if(counter == 0){
            if(currentImage == 0){
                setImage("images/pacman-close.png");
            } else if (currentImage == 1){
                setImage("images/pacman-open.png");
            }

            currentImage = (currentImage + 1) % 2;
        }
        counter = (counter + 1)%10;
    }

    public void collisions(){
        int x = getX();
        int y = getY();
        if(isTouching(Wall.class)){

            if(Greenfoot.isKeyDown("right")){
                setLocation(x - OFFSET, y);
            }
            else if(Greenfoot.isKeyDown("left")){
                setLocation(x + OFFSET, y);
            }
            else if(Greenfoot.isKeyDown("down")){
                setLocation(x, y - OFFSET);
            }
            else if(Greenfoot.isKeyDown("up")){
                setLocation(x, y + OFFSET);
            }

        }
    }

    public void teletrasporte(){
        if(isTouching(HuecoDerecha.class)){
            setLocation(50, 400);
        }
        else if(isTouching(HuecoIzquierda.class)){
            setLocation(950, 400);
        }
    }
    
    void eatItems(){
        Items item = null;
       
       switch(dir)
       {
           case 3: 
           item = (Items)getOneObjectAtOffset(10, 0, Items.class);
           break;
           
           case 2: 
           item = (Items)getOneObjectAtOffset(-10, 0, Items.class);
           break;
           
           case 1: 
           item = (Items)getOneObjectAtOffset(0, 10, Items.class);
           break;
           
           case 0: 
           item = (Items)getOneObjectAtOffset(0, -10, Items.class);
           break;
       }
       if(item != null)
       {
           points = points + item.getPoints();
           World world;
           world= getWorld();
           world.removeObject(item);
           getWorld().showText(" = " + points, 100, 785);
       }
    }
}
