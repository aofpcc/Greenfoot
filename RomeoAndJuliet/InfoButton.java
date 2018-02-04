import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InfoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoButton extends GameUI
{
    /**
     * Act - do whatever the InfoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean isNormal;
    private int time;
    public InfoButton ()
    {
        animNormal = new GreenfootImage("Button/InfoButton/notclick.png");
        setImage(animNormal);
        animClick = new GreenfootImage("Button/InfoButton/holdon.png");
        isNormal = true;
    }
    
    public void act()
    {
        if( !isNormal ){
            time--;
            if(time == 0) isNormal = true;
        }
        else if( Greenfoot.getMouseInfo()!=null &&Greenfoot.mousePressed(this) ){
            setImage(animClick);
            isNormal = false;
            time = 10;
        }
        else if(isNormal)
        {
            setImage(animNormal);
        }
        
    }    
}
