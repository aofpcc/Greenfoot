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
    
    
    
    public Slash(Characters owner, Vector2 position){
      super( owner, position);
      skillDown = new Animation("TestCharacters/Wizard/Skills/Slash/skillDown" , 6, owner.getSize().getX(), owner.getSize().getY() );
      skillLeft = new Animation("TestCharacters/Wizard/Skills/Slash/skillLeft" , 6, owner.getSize().getX(), owner.getSize().getY() );
      skillUp = new Animation("TestCharacters/Wizard/Skills/Slash/skillUp" , 6, owner.getSize().getX(), owner.getSize().getY() );
      skillRight = new Animation("TestCharacters/Wizard/Skills/Slash/skillRight" , 6, owner.getSize().getX(), owner.getSize().getY() );
     
      setSkillFrame(6);
    }
    
    @Override
    public void action(){
      switch( getOwner().getDirect() ){
        case 1: setCurrentAnimation( skillDown ); break;
        case 2: setCurrentAnimation( skillLeft ); break;
        case 3: setCurrentAnimation( skillUp ); break;
        case 4: setCurrentAnimation( skillRight ); break;
      }
      
    }
    
}
