import java.util.*;
/**
 * Write a description of class Slash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slash extends Skill 
{
    private Animation skillDown;
    private Animation skillLeft;
    private Animation skillUp;
    private Animation skillRight;
    
    private int changeX, changeY;
    private int range;
    
    public Slash(Characters owner, Vector2 position){
      super( owner, position);
      skillDown = new Animation("TestCharacters/Wizard/Skills/Slash/skillDown" , 6, owner.getSize().getX(), owner.getSize().getY() );
      skillLeft = new Animation("TestCharacters/Wizard/Skills/Slash/skillLeft" , 6, owner.getSize().getX(), owner.getSize().getY() );
      skillUp = new Animation("TestCharacters/Wizard/Skills/Slash/skillUp" , 6, owner.getSize().getX(), owner.getSize().getY() );
      skillRight = new Animation("TestCharacters/Wizard/Skills/Slash/skillRight" , 6, owner.getSize().getX(), owner.getSize().getY() );
     
      setSkillFrame(6);
      range = 10;
    }
    
    @Override
    public void action(){
      switch( getOwner().getDirect() ){
        case 1: setCurrentAnimation( skillDown ); 
                changeX = 0; changeY = range;
                break;
        case 2: setCurrentAnimation( skillLeft ); 
                changeX = -range; changeY = 0;
                break;
        case 3: setCurrentAnimation( skillUp ); 
                changeX = 0; changeY = -range;
                break;
        case 4: setCurrentAnimation( skillRight ); 
                changeX = range; changeY = 0;
                break;
      }
      sendDamage();
    }
    
    public void sendDamage(){
      BasicStatus owner = getOwner();
      List<Monster> monsters = owner.getWorld().getObjectsAt( owner.getPosition().getX() + changeX, owner.getPosition().getY()+changeY, Monster.class );
      for( Monster m : monsters ){
        m.getDamage( owner.getAtk() );
      }
    }
    
}
