package Dungeon;

/**
 *
 * @author dylanoleary
 */
public class Player {
    private final int length;
    private final int height;
    private int x;
    private int y;
    
    public Player(int length, int height){
        this.length = length;
        this.height = height;
        this.x = 0;
        this.y = 0;       
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void move(String direction){
        if(direction.equals("w")){
            int moveUp = -1;
            
            if(this.y + moveUp < 0){
                
            }else{
                this.y+= moveUp;
            }
        }
        
        if(direction.equals("s")){
            
            if(this.y + 1 == this.height){
                this.y = height - 1;
            }else{
               this.y+= 1; 
            }               
        }
        
        if(direction.equals("a")){
            int moveLeft = -1;
            
            if(this.x + moveLeft < 0){
                
            }else{
                this.x+= moveLeft;
            }
        }
        
        if(direction.equals("d")){
            int moveRight = 1;
            
            if(this.x + moveRight < length){
                this.x+= moveRight;
            }else{
                
            }
        }        
    }
    
    @Override
    public int hashCode(){
        return this.x + this.y;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        
        if(getClass() != o.getClass()){
            return false;
        }
        
        Player p = (Player) o;
        
        if(this.hashCode() == p.hashCode()){
            return true;
        }else{
            return false;
        }
    }
       
    @Override
    public String toString(){
        return "@ " + x + " " + y;
    }
           
}
