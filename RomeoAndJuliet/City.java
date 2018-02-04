import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.*;

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
    
    private Controller controller;
    
    public City()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // width , height
        super(1200, 700, 1, false);
        positionBG = new Vector2(600, 350);
        
        width = getWidth();
        height = getHeight();
        //System.out.println(width);
        bgSize = 32;
        int w, h;
        h = height/bgSize + 5;
        w = width/bgSize + 5;
        bg = new Floor[w*h];
        
        
        // Add Object
        player = new Wizard("Aof", new Vector2(600, 350), new Vector2( 75, 80));
        player.setHpBar( new HealthBar(player) );
       
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        
        // set floor 
        for(int i = 0; i < w; ++i){
            for(int j = 0; j < h; ++j){
                bg[i+j] = new Floor("walked/brick/00", bgSize, i*bgSize, j*bgSize );
                addObject( bg[i+j] , bg[i+j].getX(), bg[i+j].getY() );
            }
        }
        addObject(player, player.getPosition().getX(), player.getPosition().getY());
        addObject( player.getHpBar(), player.getPosition().getX(), player.getPosition().getY()-(player.getSize().getY()/2) );
        Greenfoot.setSpeed(48);
        
        controller = new Controller(player);
        addObject(controller, -100, -100);
        
        //UI 
        addObject(new InfoButton(), width-30, 30); 
        
        for(int i = 0; i < 15; ++i){
            Skeleton test = new Skeleton( new Vector2(100 + i*30, 100 + i*30), new Vector2( 75, 80 ) );
            test.setHpBar( new HealthBar(test) );
            addObject(test, test.getPosition().getX(), test.getPosition().getY());
            addObject( test.getHpBar(), test.getPosition().getX(), test.getPosition().getY()-(test.getSize().getY()/2) );
        }
        
        setPaintOrder( GameUI.class, HealthBar.class );
    }
    
    public void act(){
      if( player != null && player.isMoving()){
        if( checkBounded())
          setWorldRelate();
      }
      
      // sort by 
      List<BasicStatus> monsters = getObjects( BasicStatus.class );
      Collections.sort( monsters, new Comparator<BasicStatus>(){
          @Override
          public int compare(BasicStatus a, BasicStatus b){
            return a.getPosition().getY() - b.getPosition().getY();
          }
        } );
      //Greenfoot.stop();BasicStatus
      ///boolean bY = false;
      for( BasicStatus m : monsters ){
          removeObject(m);
          addObject(m, m.getPosition().getX(), m.getPosition().getY());
      }
      
      /*
      int mb = 1024*1024;
      Runtime runtime = Runtime.getRuntime();
      long usedMem = ( runtime.totalMemory()-runtime.freeMemory())/mb;
      System.out.println(usedMem + " : " + (runtime.totalMemory()/mb));
      */
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
        
        //System.out.println( "x : " + x + ",y : " +y );
        //System.out.println( "Speed : " + speed + " , Height: " + height + ",Width : " + width ); 
        
        boolean check = false;
        switch( d ){
            case 1:
                if( y >= height/2 && py-speed >= height/2  )
                    check = true;
                break;
            case 2:
                if( x <= width/2 && px+speed <= width/2  )
                    check = true;
                break;
            case 3:
                if( y <= height/2 &&  py+speed <= height/2 )
                    check = true;
                break;
            case 4:
                if( x >= width/2 && px-speed >= width/2)
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
      int changeX = 0, changeY =0;
      for( Floor f : floors ){
        switch( d ){
            case 1:
                changeX = 0;
                changeY = - speed;
                break;
            case 2:
                changeX = speed;
                changeY = 0;
                break;
            case 3:
                changeX = 0;
                changeY = speed;
                break;
            case 4:
                changeX = - speed;
                changeY = 0;
                break;
        }  
        f.setPosition( f.getX() + changeX , f.getY() + changeY);
        f.setLocation( f.getX() , f.getY() );
      }
      List<Monster> monsters = getObjects(Monster.class);
      for( Monster m : monsters ){
        if( m == null ) continue;
        switch( d ){
            case 1:
                changeX = 0;
                changeY = - speed;
                break;
            case 2:
                changeX = speed;
                changeY = 0;
                break;
            case 3:
                changeX = 0;
                changeY = speed;
                break;
            case 4:
                changeX = - speed;
                changeY = 0;
                break;
        }
        m.setPosition( new Vector2( m.getPosition().getX() + changeX , m.getPosition().getY() + changeY) );
        m.setLocation( m.getPosition().getX(), m.getPosition().getY() );
      }
    }
    
}
