package Dungeon;

import java.util.Random;

/**
 *
 * @author dylanoleary
 */
public class Vampire {
    private final int length;
    private final int height;
    private int x;
    private int y;
    private Random random = new Random();
    
    public Vampire(int length, int height){
        this.length = length;
        this.height = height;
        this.x = random.nextInt(length);
        this.y = random.nextInt(height);
        
        while(x + y == 0){
            rePosition();
        }
    }
    
    public void rePosition(){
        x = random.nextInt(length);
        y = random.nextInt(height);
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void move(int numberOfMoves){
        while(numberOfMoves > 0){
            rePosition();
            
            numberOfMoves--;
        }
    }
    
    @Override
    public int hashCode(){
        return x + y;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        
        if(getClass() != o.getClass()){
            return false;
        }
        
        Vampire v = (Vampire) o;
        
        if(this.hashCode() == v.hashCode()){
            return true;
        }else{
            return false;
        }           
    }
    
    @Override
    public String toString(){
       return "v " + x + " " + y;
    }
}
