import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // size should be equals
    private GreenfootImage image;
    public Floor(String namePath, int size){
        image = new GreenfootImage(namePath+ ".png");
        //image.scale( size, size );
        setImage( image );
    }
}
