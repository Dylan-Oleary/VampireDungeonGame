
package Dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dylanoleary
 */

public class Dungeon {
    private final int length;
    private final int height;
    private final int vampires;
    private int moves;
    private boolean vampiresMove;
    
    private List<Vampire> vampireList;
    private Player player;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        
        this.vampireList = new ArrayList<Vampire>();
        
        for(int i = 0; i < this.vampires; i++){
            this.vampireList.add(new Vampire(length, height));
        }
        
        this.player = new Player(length, height);
    }
    
    public void printGrid(){        
        String line = "";
        
        for(int y = 0; y < height; y++){//Height
            for(int x = 0; x < length; x++){//Length
                         
                if(x == player.getX() && y == player.getY()){
                    line+= "@";
                }
                
                for(Vampire v : this.vampireList){
                    if(x == v.getX() && y == v.getY()){//Print Vampires
                        line+= "v";
                    }
                }
                
                if(line.length() == x){
                    line+= ".";
                }               
            }
            
            System.out.print(line); //Print the built line
            line = "";
            System.out.println();
        }
        
        System.out.println();
    }
    
    public void printInfo(){
        System.out.print(this.moves + "\n\n");
        
        System.out.print(player.toString() + "\n");
        
        for(Vampire v : this.vampireList){
            System.out.println(v.toString());
        }
        
        System.out.print("\n");
    }
    
    public void movePlayer(String commands){
        //Player completes their moves first, then the Vampires.
        for(int i = 0; i < commands.length(); i++){
            String direction = String.valueOf(commands.charAt(i));
            player.move(direction);
        }        
    }
    
    public void checkAndKillVampires(){
        ArrayList<Vampire> toBeRemoved = new ArrayList<Vampire>();
                
        for(Vampire v : this.vampireList){                   
            if(player.getX() == v.getX() && player.getY() == v.getY()){
                toBeRemoved.add(v);
            }
        }
                
        if(!toBeRemoved.isEmpty()){
            this.vampireList.remove(toBeRemoved.get(0)); 
        }        
    }
    
    public void moveVampires(String commands){
        if(!this.vampiresMove == false){
            for(Vampire v : this.vampireList){
                v.move(commands.length()); //Moves == how many the player made.
                    
                //Ensures no 2 vampires are in the same spot.
                while(this.vampireList.contains(v.hashCode())){
                    v.rePosition();
                }
            }
        }        
    }
    
    
    public void run(){
        Scanner reader = new Scanner(System.in);
        
        while(moves > 0){
            printInfo();
            printGrid();
            
            System.out.print("Enter your moves: ");
            
            String commands = reader.nextLine();
            
            movePlayer(commands);
            checkAndKillVampires();
            moveVampires(commands);
            
            if(this.vampireList.isEmpty()){
                System.out.print("YOU WIN");
                break;
            }
            
            reader.reset();
            
            moves--;
        }
        
        if(moves == 0){
            System.out.print("YOU LOSE");
        }
    }
}
