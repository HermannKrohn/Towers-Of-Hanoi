/**
 * Write a description of class Rings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ring 
{
    int xLocation, yLocation, height, width, arcH, arcW;
    
    //Constructor
    public Ring(int x, int y, int h, int w, int ah, int aw)
    {
        xLocation = x;
        yLocation = y;
        height = h;
        width = w;
        arcH = ah;
        arcW = aw;
    }

    //gets x location
    public int getX()
    {
        return xLocation;
    }

    //gets y location
    public int getY()
    {
        return yLocation;
    }
    
    //gets height of ring
    public int getHeight()
    {
        return height;
    }
    
    //gets width of ring
    public int getWidth()
    {
        return width;
    }
    
    //gets arc height of ring
    public int getAH()
    {
        return arcH;
    }
    
    //gets arc width of ring
    public int getAW()
    {
        return arcW;
    }
    
    
}