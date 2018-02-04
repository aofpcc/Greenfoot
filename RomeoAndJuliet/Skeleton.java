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
      standDown = new Animation( "Monsters/Skeleton/standDown/down", 1, size.getX(), size.getY() );
      setSpeed(3);
      setAnimation(standDown);
      setImage(standDown.getFrame());
      die = new Animation( "Monsters/Skeleton/die/die", 6, size.getX(), size.getY() );
    }
}
