import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wizard extends Characters {
  public Wizard(String name, Vector2 origin){
    super( "Wizard", 5, 1, 9, TYPE.MAGIC );
    this.setPlayerName(name);
    //double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp
    this.setScale( 1,1,1,1,1,1 );
    this.resetStat();
    this.restore();
    setPosition(origin);
  }
}
