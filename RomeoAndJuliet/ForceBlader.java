import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForceBlader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForceBlader extends Characters  {
  private Animation walkingDown;
  private Animation walkingLeft;
  private Animation walkingUp;
  private Animation walkingRight;
  private Animation standDown;
  private Animation standLeft;
  private Animation standUp;
  private Animation standRight;
  
  public ForceBlader(String name, Vector2 origin, Vector2 size){
    super( "ForceBlader", 10, 3, 2, TYPE.MELEE );
    //double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp
    this.setPlayerName(name);
    setScale( 2,1,1,1,1,1 );
    resetStat();
    restore();
    setPosition(origin);
    setSize(size);
    
    walkingDown = new Animation( "TestCharacters/ForceBlader/walkingDown", 3, getSize().getX(), getSize().getY() );
    walkingLeft = new Animation( "TestCharacters/ForceBlader/walkingLeft", 3, getSize().getX(), getSize().getY() );
    walkingUp = new Animation( "TestCharacters/ForceBlader/walkingUp", 3, getSize().getX(), getSize().getY() );
    walkingRight = new Animation( "TestCharacters/ForceBlader/walkingRight", 3, getSize().getX(), getSize().getY() );
    
    standDown = new Animation( "TestCharacters/ForceBlader/standDown", 1, getSize().getX(), getSize().getY() );
    standUp = new Animation( "TestCharacters/ForceBlader/standUp", 1, getSize().getX(), getSize().getY() );
    standLeft = new Animation( "TestCharacters/ForceBlader/standLeft", 1, getSize().getX(), getSize().getY() );
    standRight = new Animation( "TestCharacters/ForceBlader/standRight", 1, getSize().getX(), getSize().getY() );
    
    setSpeed(3);
    setAnimation(walkingDown);
    setImage(walkingDown.getFrame());
  }
  
  @Override
  public void act(){
    super.act();
    if(Greenfoot.isKeyDown("Down")){
        //if( getDirect() != 1 )
        setDirect(1);
        setAnimation(walkingDown);
        if(canMove()){
            walk();
            setIsMoving(true);
        }
    }
    else if(Greenfoot.isKeyDown("Left")){
        //if( getDirect() != 2 )
        setDirect(2);
        setAnimation(walkingLeft);
        if(canMove()){
            walk();
            setIsMoving(true);
        }
    }
    
    else if(Greenfoot.isKeyDown("Up")){
        //if( getDirect() != 3 )
        setDirect(3);
        setAnimation(walkingUp);
        if(canMove()){
            walk();
            setIsMoving(true);
        }
    }
    else if(Greenfoot.isKeyDown("Right")){
        //if( getDirect() != 4 )
        setDirect(4);
        setAnimation(walkingRight);
        if(canMove()){
            
            walk();
            setIsMoving(true);
        }
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
  
  public boolean canMove(){
    if( getDirect() == 1 ||  getDirect() == 3 )
        return nextStep() - 10 > 0 && nextStep() < 650;
    return nextStep() - 10 > 0 && nextStep() < 1150;
  }
  
  @Override
  public void walk(){
    super.walk();
    
  }
  
}
