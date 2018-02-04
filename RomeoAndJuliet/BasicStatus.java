import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class BasicStatus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class BasicStatus extends Actor{
  private String name;
  private int totalPoint = 0;
  
  // UI
  private HealthBar hpBar;
  
  //Skill
  private boolean isSkilling = false;
  private int skillFrame;
  private Skill attack;
  
  // movement
  private int direction = 1; // 1 down 2 left 3 up 4 right
  private Vector2 position;
  private Animation currentAnim;
  private Vector2 size;
  private int speed;
  private boolean isMoving = false;
  private int animDelay = 1;
  
  // Basic of all status
  private int strength;
  private int agility;
  private int intelligent;
  
  // Dead
  protected Animation die;
  private boolean isDead;
  private int dieTime = 0;
  
  public enum TYPE{
    MELEE,
    RANGE,
    MAGIC
  }
  
  private TYPE typeObj;
  
  // Base Status
  private double atk;
  private double def;
  private double evas;
  private double crit;
  private double currentHp;
  private double hp;
  
  // Scale of each status
  private double scaleAtk;
  private double scaleDef;
  private double scaleEvas;
  private double scaleCrit;
  private double scaleHp;
  
  public BasicStatus(String name, int strength, int agility, int intelligent, TYPE typeObj){
    this.strength    = strength;
    this.agility     = agility;
    this.intelligent = intelligent;
    this.typeObj     = typeObj;
    this.name        = name;
  }
  
  public BasicStatus( String name, double atk, double def, double evas, double crit, double hp){
    this.atk  = atk;
    this.def  = def;
    this.evas = evas;
    this.crit = crit;
    this.hp   = hp;
  }
  
  public void setScale(  double scaleAtk, double scaleDef, double scaleEvas, double scaleCrit, double scaleHp ){
    this.scaleAtk  = scaleAtk;
    this.scaleDef  = scaleDef;
    this.scaleEvas = scaleEvas;
    this.scaleCrit = scaleCrit;
    this.scaleHp   = scaleHp;
  }
  // status = scale x basic stat
  public void resetStat(){
    // default ATK
    switch(typeObj){
      case MELEE :
        this.atk = strength * scaleAtk;
        break;
      case RANGE: 
        this.atk = agility * scaleAtk;
        break;
      case MAGIC: 
        this.atk = intelligent * scaleAtk;
        break;
      default: 
        this.atk = strength * scaleAtk;
    }
    
    // the others
    this.def  = strength * scaleDef;
    this.evas = agility * scaleEvas;
    this.crit = agility * scaleCrit;
    this.hp   = strength * scaleHp;
  }
  
  // getter setter
  public void setStrength(int strength){
    this.strength = strength;
  }
  public void setAgility(int agility){
    this.agility = agility;
  }
  public void setIntelligent(int intelligent){
    this.intelligent = intelligent;
  }
  public void setCurrentHp(double currentHp){
    this.currentHp = currentHp;
  }
  public int getStrength(){
    return strength;
  }
  public int getAgility(){
    return agility;
  }
  public int getIntelligent(){
    return intelligent;
  }
  public double getCurrentHp(){
    return currentHp;
  }
  // get max hp
  public double getMaxHp(){
    return hp;
  }
  // set  get point
  public void setTotalPoint(int point){
    this.totalPoint = point;
  }
  public int getTotalPoint(){
    return totalPoint;
  }
  
  public TYPE getTypeObj(){
    return typeObj;
  }
  // Get All Info
  public String toString(){
    String ans = "";
    ans += "Name         :    " + name + '\n';
    ans += "Total Point  :    " + totalPoint + '\n';
    ans += "Strength     :    " + strength + '\n';
    ans += "Agility      :    " + agility + '\n';
    ans += "Intelligent  :    " + intelligent + '\n';
    ans += "Type Object  :    " + typeObj + '\n';
    ans += "Attack       :    " + atk + '\n';
    ans += "Defend       :    " + def + '\n';
    ans += "Evasion      :    " + evas + '\n';
    ans += "Critical     :    " + crit + '\n';
    ans += "Health Point :    " + hp + '\n' ;
    ans += "Current HP   :    " + currentHp + '\n';
    return ans;
  }
  // Restore Regen mana
  public void restore(){
    healHp(hp);
  }
  
  public void healHp(double addedHp){
    if( currentHp + addedHp > hp )
      currentHp = hp;
    else
      currentHp += addedHp;
  }
  
  // set position
  public void setPosition(Vector2 v){
    position = v;
  }
  public Vector2 getPosition(){
    return position;
  }
  
  // Move
  public void walk(){
        switch( direction ){
          case 1:
            position = new Vector2(position.getX() , position.getY() + speed);
            setLocation( position.getX(), position.getY() );
            break;
          case 2:
            position = new Vector2(position.getX() - speed, position.getY());
            setLocation( position.getX(), position.getY() );
            break;
          case 3:
            position = new Vector2(position.getX() , position.getY() -  speed);
            setLocation( position.getX(), position.getY() );
            break;
          case 4:
            position = new Vector2(position.getX() + speed, position.getY());
            setLocation( position.getX(), position.getY() );
            break;
        }
    
  }
  
  public void setAnimation(Animation anim){
    this.currentAnim = anim;
  }
  
  public Animation getAnimation(){
    return currentAnim;  
  }
  // Action each 
  public void act(){
    
    if( isDead && skillFrame == 0 ){
         dieTime++;
         if( dieTime >= 20 ){
            getWorld().removeObject(this);
         }
    }
    else if( animDelay++ >= speed -1 ){
        if( skillFrame > 0 ){
            skillFrame--;
        }
        setImage( currentAnim.getFrame() );
        
        animDelay = 0;
        
        //Test
        //getDamage( 0.1 );
    }
    if( currentHp > 0 ){
        hpBar.action();
    }else if( currentHp <= 0 && !isDead ){
        getWorld().removeObject(hpBar);
        die();
    }
  }
  
  public void setSize(Vector2 size){
    this.size = size;  
  }
  public Vector2 getSize(){
    return size;  
  }
  public int getDirect(){
    return direction;
  }
  public void setDirect(int d){
    direction = d;
  }
  public void setSpeed(int s){
    speed = s;  
  }
  public int getSpeed(){
    return speed;  
  }
  public void setIsMoving(boolean b){
    this.isMoving = b;
  }
  public boolean isMoving(){
    return isMoving;
  }
  public int nextStep(){
    switch( direction ){
          case 1:
          return position.getY() + speed;
          case 2:
           return position.getX() - speed;
          case 3:
            return position.getY() -  speed;
          case 4:
            return position.getX() + speed;
    }
    return 0;
  }
  
  
  public void setIsSkilling( boolean b ){
    this.isSkilling = b;
  }
  public boolean isSkilling(){
    return isSkilling;
  }
  
  public void setSkillFrame(int sf){
    this.skillFrame = sf;
  }
  public int getSkillFrame(){
    return skillFrame;  
  }
  
  public void setAttack(Skill sk){
    this.attack = sk;
  }
  public Skill getAttack(){
    return attack;
  }
  
  public void setHpBar(HealthBar hpBar){
    this.hpBar = hpBar;
  }
  public HealthBar getHpBar(){
    return hpBar;  
  }
  
  public void attack(){
    if( skillFrame == 0 ){
        attack.action();
        skillFrame = attack.getSkillFrame();
        currentAnim = attack.getCurrentAnimation();
    }
  }
  
  public void getDamage(double dmg){
    if( !isDead )this.currentHp -= dmg;
  }
  
  public void die(){
    skillFrame = die.getAllFrames();  // beware s
    currentAnim = die;
    isDead = true;
  }
  public boolean isDead(){
    return isDead;  
  }
  
  // All stat
  public double getAtk(){
    return atk;
  }
  
  public String getName(){
    return name;  
  }
  
}
