import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Characters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Characters extends BasicStatus {
  
  private double mp;
  private double currentMp;
  private double scaleMp;
  private String namePlayer;
  
  public Characters(String name, int strength, int agility, int intelligent,TYPE typeObj){
    super(name, strength, agility, intelligent, typeObj);
  }
  
  
  public void setScale(  double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp, double scaleMp ){
    super.setScale(scaleAtk, scaleDef, scaleEvas, scaleCrit, scaleHp );
    this.scaleMp = scaleMp;
  }
  
  @Override
  public void resetStat(){
    super.resetStat();
    this.mp = getIntelligent() * scaleMp;
  }
  
  @Override
  public String toString(){
    String ans = super.toString();
    ans += "Mana Point   :    " + mp + '\n';
    ans += "Current Mp   :    " + currentMp + '\n';
    ans += "---------------------------------";
    return ans;
  }
  
  @Override
  public void restore(){
    super.restore();
    healMp(mp);
  }
  
  public void healMp(double addedMp){
    if( currentMp + addedMp > mp )
      currentMp = mp;
    else
      currentMp += addedMp;
  }
  
  public void setPlayerName(String namePlayer){
    this.namePlayer = namePlayer;
  }
  
}
