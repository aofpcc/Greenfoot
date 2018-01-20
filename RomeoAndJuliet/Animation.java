import greenfoot.*;
/**
 * Write a description of class Animation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animation extends Actor
{
    private int currentFrame;
    private int allFrames;
    private String nameSprite;
    private GreenfootImage[] sprites;
    public Animation(String name, int allFrames){
        super();
        this.allFrames = allFrames;
        nameSprite = name;
        sprites = new GreenfootImage[allFrames];
        currentFrame = 0;
        for(int i = 0; i < allFrames; ++i){
          sprites[i] = new GreenfootImage(name+i+".png");
        }
    }
    
    public void nextFrame(){
        setImage( sprites[currentFrame] );
        currentFrame++;
        if(currentFrame == allFrames ) currentFrame = 0;
    }
}
