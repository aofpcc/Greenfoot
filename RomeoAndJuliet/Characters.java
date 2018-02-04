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
  
  private Animation walkingDown;
  private Animation walkingLeft;
  private Animation walkingUp;
  private Animation walkingRight;
  
  private Animation standDown;
  private Animation standLeft;
  private Animation standUp;
  private Animation standRight;
  private Animation attackAnimation;
  
  private Skill[] skills;
  
  public Characters(String name, int strength, int agility, int intelligent,TYPE typeObj){
    super(name, strength, agility, intelligent, typeObj);
    maxDelay = 3;
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
  
  public void setWalkingDown(Animation walkingDown){
    this.walkingDown = walkingDown;
  }
  public void setWalkingLeft(Animation walkingLeft){
    this.walkingLeft = walkingLeft;
  }
  public void setWalkingUp(Animation walkingUp){
    this.walkingUp = walkingUp;
  }
  public void setWalkingRight(Animation walkingRight){
    this.walkingRight = walkingRight;
  }
  
  public Animation getWalkingDown(){
    return walkingDown;
  }
  public Animation getWalkingLeft(){
    return walkingLeft;
  }
  public Animation getWalkingUp(){
    return walkingUp;
  }
  public Animation getWalkingRight(){
    return walkingRight;
  }
  
  public void setStandDown(Animation standDown){
    this.standDown = standDown;
  }
  public void setStandLeft(Animation standLeft){
    this.standLeft = standLeft;
  }
  public void setStandUp(Animation standUp){
    this.standUp = standUp;
  }
  public void setStandRight(Animation standRight){
    this.standRight = standRight;
  }
  public void setAttackAnimation(Animation anim){
    this.attackAnimation = anim;
  }
  
  public Animation getStandDown(){
    return standDown;
  }
  public Animation getStandLeft(){
    return standLeft;
  }
  public Animation getStandUp(){
    return standUp;
  }
  public Animation getStandRight(){
    return standRight;
  }
  public Animation getAttackAnimation(){
    return attackAnimation;  
  }
  
}
