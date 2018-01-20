 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test extends Animation
{
    /**
     * Act - do whatever the Test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String name;
    public Test(){
      super( "fish", 3 );
    }
    
    public void act() 
    {
        // Add your action code here.
        //move(2);
        nextFrame();
    }    
}
