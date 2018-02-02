import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForceBlader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForceBlader extends Characters  {
  
  
  public ForceBlader(String name, Vector2 origin, Vector2 size){
    super( "ForceBlader", 10, 3, 2, TYPE.MELEE );
    //double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp
    this.setPlayerName(name);
    setScale( 2,1,1,1,1,1 );
    resetStat();
    restore();
    setPosition(origin);
    setSize(size);
    
    setWalkingDown(new Animation( "TestCharacters/ForceBlader/walkingDown", 3, getSize().getX(), getSize().getY() ));
    setWalkingLeft(new Animation( "TestCharacters/ForceBlader/walkingLeft", 3, getSize().getX(), getSize().getY() ));
    setWalkingUp(new Animation( "TestCharacters/ForceBlader/walkingUp", 3, getSize().getX(), getSize().getY() ));
    setWalkingRight( new Animation( "TestCharacters/ForceBlader/walkingRight", 3, getSize().getX(), getSize().getY() ));
    
    setStandDown ( new Animation( "TestCharacters/ForceBlader/standDown", 1, getSize().getX(), getSize().getY() ));
    setStandUp ( new Animation( "TestCharacters/ForceBlader/standUp", 1, getSize().getX(), getSize().getY() ));
    setStandLeft ( new Animation( "TestCharacters/ForceBlader/standLeft", 1, getSize().getX(), getSize().getY() ));
    setStandRight ( new Animation( "TestCharacters/ForceBlader/standRight", 1, getSize().getX(), getSize().getY() ));
    
    setSpeed(3);
    setAnimation(getWalkingDown());
    setImage(getWalkingDown().getFrame());
  }

  
}
