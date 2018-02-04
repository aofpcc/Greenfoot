import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends BasicStatus
{
    protected Animation walkingDown;
    protected Animation walkingLeft;
    protected Animation walkingUp;
    protected Animation walkingRight;
    
    protected Animation standDown;
    protected Animation standLeft;
    protected Animation standUp;
    protected Animation standRight;
    
    protected int delay;
    protected static Random random;
    protected int nextLimit;
    
    public Monster( String name, double atk, double def, double evas, double crit, double hp){
      super(name, atk, def, evas, crit, hp);
      restore();
      delay = 0;
      random = new Random();
      nextLimit = random.nextInt()%100 + 60;
    }
    
    @Override
    public void act(){
      super.act();
      List<Characters> playerSet = getObjectsInRange( 100, Characters.class);
      if( getSkillFrame() > 0 || isDead()){
        
      }else if( playerSet.size() > 0  ){
        int x = playerSet.get(0).getPosition().getX() - getPosition().getX(); // neg => right, pos => left
        int y = playerSet.get(0).getPosition().getY() - getPosition().getY(); // neg => up , pos => down
        int dir = 1;
        if( Math.abs(x) >= Math.abs(y) ){
          if( x >= 0 ) dir = 4;
          else dir = 2;
        }else{
          if( y <= 0 ) dir = 3;
          else dir = 1;
        }
        setDirect(dir);
        switch(dir){
         case 1: setAnimation(walkingDown); break;
         case 2: setAnimation(walkingLeft); break;
         case 3: setAnimation(walkingUp); break;
         case 4: setAnimation(walkingRight); break;
        }
        if(canMove()){
          walk();
          setIsMoving(true);
        }
      }else if( delay++ >= nextLimit ){
        randomMove();
        delay = 0;
        nextLimit = random.nextInt()%100 + 60;
      }else{
        setIsMoving(false);
       switch(getDirect()){
         case 1: setAnimation(standDown); break;
         case 2: setAnimation(standLeft); break;
         case 3: setAnimation(standUp); break;
         case 4: setAnimation(standRight); break;
       }
      }
    }
    
    public void randomMove(){
      int dir = random.nextInt()%4 + 1;
      setDirect(dir);
      switch(getDirect()){
         case 1: setAnimation(walkingDown); break;
         case 2: setAnimation(walkingLeft); break;
         case 3: setAnimation(walkingUp); break;
         case 4: setAnimation(walkingRight); break;
       }
      if(canMove()){
          walk( random.nextInt()%3 + 1 );
          setIsMoving(true);
      }
    }
    
    public boolean canMove(){
      if( getDirect() == 1 ||  getDirect() == 3 )
          return nextStep() - 10 > 0 && nextStep() < 650;
      return nextStep() - 10 > 0 && nextStep() < 1150;
    }
    
}
