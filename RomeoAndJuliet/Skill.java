/**
 * Write a description of class Skill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skill  
{
    // instance variables - replace the example below with your own
    private Vector2 position;
    private Characters owner;
    private Animation currentAnim;
    private int skillFrame;
    
    public Skill(Characters owner, Vector2 position){
      this.position = position;
      this.owner = owner;
    }
    
    public void setCurrentAnimation(Animation currentAnim){
      this.currentAnim = currentAnim;
    }
    
    public Characters getOwner(){
      return owner;
    }
    public Vector2 getPosition(){
      return position;
    }
    public Animation getCurrentAnimation(){
      return currentAnim;
    }
    
    public void setPlayerAnimation(){
      owner.setSkillFrame( currentAnim.getAllFrames() );
      owner.setAnimation( currentAnim );
    }
    
    public void action(){
    
    }
    
    public void setSkillFrame(int skillFrame){
      this.skillFrame = skillFrame;
    }
    public int getSkillFrame(){
      return skillFrame;
    }
    
}
