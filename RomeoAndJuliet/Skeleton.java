import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Monster
{
    public Skeleton( Vector2 position, Vector2 size ){
      // super(name,   atk, def, evas, crit, hp);
      super("Skeleton", 2,   1,   1,   1,   50);
      setSize(size);
      setPosition(position);
<<<<<<< HEAD
      standDown = new Animation( "Monsters/Skeleton/standDown/down", 1, size.getX(), size.getY() );
      setSpeed(3);
=======
      
      walkingDown = new Animation( "Monsters/Skeleton/walkingDown/down", 8, size.getX(), size.getY() );
      walkingLeft = new Animation( "Monsters/Skeleton/walkingLeft/left", 8, size.getX(), size.getY() );
      walkingUp = new Animation( "Monsters/Skeleton/walkingUp/up", 8, size.getX(), size.getY() );
      walkingRight = new Animation( "Monsters/Skeleton/walkingRight/right", 8, size.getX(), size.getY() );
      
      standDown = new Animation( "Monsters/Skeleton/standDown/down", 1, size.getX(), size.getY() );
      standLeft = new Animation( "Monsters/Skeleton/standLeft/left", 1, size.getX(), size.getY() );
      standUp = new Animation( "Monsters/Skeleton/standUp/up", 1, size.getX(), size.getY() );
      standRight = new Animation( "Monsters/Skeleton/standRight/right", 1, size.getX(), size.getY() );
      
      setSpeed(1);
      maxDelay = 3;
>>>>>>> 825a3a9e86673ac7a0e70897eeb84599bf21f0f5
      setAnimation(standDown);
      setImage(standDown.getFrame());
      die = new Animation( "Monsters/Skeleton/die/die", 6, size.getX(), size.getY() );
    }
}
