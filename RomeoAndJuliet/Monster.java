import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends BasicStatus
{
    protected Animation standDown;
    
    public Monster( String name, double atk, double def, double evas, double crit, double hp){
      super(name, atk, def, evas, crit, hp);
      restore();
    }
    
}
