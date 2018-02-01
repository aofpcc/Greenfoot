/**
 * Write a description of class GameUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameUI  
{
    private Vector2 position;
    private Animation anim;

    public GameUI(Animation anim, Vector2 position)
    {
        this.anim = anim;
        this.position = position;
    }
    public Animation getAnimation(){
      return anim;
    }
    public Vector2 getPosition(){
      return position;
    }
}
