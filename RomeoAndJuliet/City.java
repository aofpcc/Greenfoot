import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int width;
    private int height;
    private Floor[] bg;
    private int bgSize;
    
    public City()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1, false);
        width = getWidth();
        height = getHeight();
        bgSize = 32;
        int w, h;
        h = height/bgSize + 5;
        w = width/bgSize + 5;
        bg = new Floor[w*h];
        for(int i = 0; i < w; ++i){
            for(int j = 0; j < h; ++j){
                bg[i+j] = new Floor("Brick/walkingBrick", bgSize);
                addObject( bg[i+j] , i*bgSize, j*bgSize);
            }
        }
    }
}
