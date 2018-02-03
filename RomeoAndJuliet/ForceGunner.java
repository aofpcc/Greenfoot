import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForceGunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForceGunner extends Characters {
  public ForceGunner(String name, Vector2 origin, Vector2 size){
    super( "ForceGunner", 5, 8, 2, TYPE.RANGE  );
    this.setPlayerName(name);
    //double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp
    setScale( 1,1,1,1,1,1 );
    resetStat();
    restore();
    setSize(size);
    setPosition(origin);
    
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
