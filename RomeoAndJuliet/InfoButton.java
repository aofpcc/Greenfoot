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
    
    public InfoButton ()
    {
        animNormal = new GreenfootImage("Button/InfoButton/notclick.png");
        setImage(animNormal);
        animClick = new GreenfootImage("Button/InfoButton/holdon.png");
    }
    
    public void act()
    {
        if(Greenfoot.getMouseInfo().getActor() != null ||Greenfoot.getMouseInfo().getActor() == this)
        {
            setImage(animClick);
        }
        else if(true)
        {
            setImage(animNormal);
        }
    }    
}
