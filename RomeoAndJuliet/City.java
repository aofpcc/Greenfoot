import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private Characters player;
    
    private Vector2 positionBG;
    private boolean isBounded;
    
    public City()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1, false);
        positionBG = new Vector2(600, 350);
        
        width = getWidth();
        height = getHeight();
        bgSize = 32;
        int w, h;
        h = height/bgSize + 5;
        w = width/bgSize + 5;
        bg = new Floor[w*h];
        
        
        // Add Object
        player = new ForceBlader("Aof", new Vector2(600, 350), new Vector2( 75, 75));
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();

        // set floor 
        for(int i = 0; i < w; ++i){
            for(int j = 0; j < h; ++j){
                bg[i+j] = new Floor("Brick/walkingBrick", bgSize, i*bgSize, j*bgSize );
                addObject( bg[i+j] , bg[i+j].getX(), bg[i+j].getY() );
            }
        }
        addObject(player, player.getPosition().getX(), player.getPosition().getY());
        Greenfoot.setSpeed(48);
    }
    
    public void act(){
      if(player.isMoving()){
        
        if( checkBounded())
          setWorldRelate();
      }
    }
    
    public boolean isBounded(){
      return isBounded;
    }
    
    public boolean checkBounded(){
        int x = positionBG.getX();
        int y = positionBG.getY();
        int d = player.getDirect();
        
        int px = player.getPosition().getX();
        int py = player.getPosition().getY();
        
        int speed = player.getSpeed();
        boolean check = false;
        switch( d ){
            case 1:
                if( y-speed >= 350 && py >= 350  )
                    check = true;
                break;
            case 2:
                if( x+speed <= 600 && px <= 600  )
                    check = true;
                break;
            case 3:
                if( y+speed <= 370 &&  py <= 370 )
                    check = true;
                break;
            case 4:
                if( x-speed >= 470 && px >= 600 )
                    check = true;
                break;
        }  
        isBounded = check;
        return check;
    }
    
    public void setWorldRelate(){
      List<Floor> floors = getObjects(Floor.class);
      int d = player.getDirect();
      int speed = player.getSpeed()/3;
      Vector2 position = player.getPosition();
      
      switch( d ){
            case 1:
                positionBG.setXY( positionBG.getX(), positionBG.getY()-speed );
                break;
            case 2:
                positionBG.setXY( positionBG.getX()+speed, positionBG.getY());
                break;
            case 3:
                positionBG.setXY( positionBG.getX(), positionBG.getY()+speed );
                break;
            case 4:
                positionBG.setXY( positionBG.getX()-speed, positionBG.getY());
                break;
        }  
      
      for( Floor f : floors ){
        switch( d ){
            case 1:
                f.setPosition( f.getX() , f.getY() - speed);
                f.setLocation( f.getX() , f.getY() );
                break;
            case 2:
                f.setPosition( f.getX() + speed, f.getY() );
                f.setLocation( f.getX() , f.getY() );
                break;
            case 3:
                f.setPosition( f.getX() , f.getY() + speed);
                f.setLocation( f.getX() , f.getY() );
                break;
            case 4:
                f.setPosition( f.getX() - speed, f.getY() );
                f.setLocation( f.getX() , f.getY() );
                break;
        }   
      }
    }
    
}
