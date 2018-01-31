import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForceGunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForceGunner extends Characters {
  public ForceGunner(String name, Vector2 origin){
    super( "ForceGunner", 5, 8, 2, TYPE.RANGE );
    this.setPlayerName(name);
    //double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp
    setScale( 1,1,1,1,1,1 );
    resetStat();
    restore();
    setPosition(origin);
  }
}
