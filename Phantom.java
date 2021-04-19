import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phantom extends Actor
{
    private int offset = 5;
    private int dir=0;

   

    /**
     * Act - do whatever the Phantom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movicion();
        teletrasporte();
    }   

    public void movicion(){
        move(offset);
        int x = getX();
        int y = getY();
        if(isTouching(Wall.class)){
            switch(dir){
                case -90://up
                setLocation(x, y + 5);
                rotacion();
                break;

                case 90://down
                setLocation(x, y - 5);
                rotacion();
                break;

                case 0://r
                setLocation(x - 5, y);
                rotacion();
                break;

                case 180://l
                setLocation(x + 5, y);
                rotacion();
                break;
            }

        }

    }

    public void rotacion(){
        switch(Greenfoot.getRandomNumber(4)){
            case 0://up
            dir=-90;
            setRotation​(dir);
            break;

            case 1://down
            dir=90;
            setRotation​(dir);
            break;

            case 2://r
            dir=0;
            setRotation​(dir);
            break;

            case 3://l
            dir=180;
            setRotation​(dir);
            break;
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
}
