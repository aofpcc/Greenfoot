import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wizard extends Characters {
    
  private Slash slash;
    
  public Wizard(String name, Vector2 origin, Vector2 size){
    super( "Wizard", 5, 1, 9, TYPE.MAGIC );
    this.setPlayerName(name);
    //double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp
    this.setScale( 1,1,1,1,1,1 );
    resetStat();
    restore();
    setSize(size);
    setPosition(origin);
    
    setWalkingDown(new Animation( "TestCharacters/Wizard/walkingDown", 8, getSize().getX(), getSize().getY() ));
    setWalkingLeft(new Animation( "TestCharacters/Wizard/walkingLeft", 8, getSize().getX(), getSize().getY() ));
    setWalkingUp(new Animation( "TestCharacters/Wizard/walkingUp", 8, getSize().getX(), getSize().getY() ));
    setWalkingRight( new Animation( "TestCharacters/Wizard/walkingRight", 8, getSize().getX(), getSize().getY() ));
    
    setStandDown ( new Animation( "TestCharacters/Wizard/standDown", 1, getSize().getX(), getSize().getY() ));
    setStandUp ( new Animation( "TestCharacters/Wizard/standUp", 1, getSize().getX(), getSize().getY() ));
    setStandLeft ( new Animation( "TestCharacters/Wizard/standLeft", 1, getSize().getX(), getSize().getY() ));
    setStandRight ( new Animation( "TestCharacters/Wizard/standRight", 1, getSize().getX(), getSize().getY() ));
    
    die = new Animation( "TestCharacters/Wizard/die", 5, getSize().getX(), getSize().getY() );
    
    slash = new Slash( this, getPosition() );
    setAttack(slash);
    
    setSpeed(3);
    setAnimation(getWalkingDown());
    setImage(getWalkingDown().getFrame());
  }
}
