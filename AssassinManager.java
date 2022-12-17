/**
Assassin Game
By: Kenton La
*/
import java.util.*;

public class AssassinManager
{
    //constructs two new linked lists using the AssassinNode class
    private AssassinNode killRing = new AssassinNode();
    private AssassinNode graveyard = new AssassinNode();
    
    //adds names from text file into killring
    public AssassinManager(List<String> names)
    {
        if(names == null || names.size() == 0){
            throw new IllegalArgumentException();
        }
        
        for(int i = 0; i < names.size(); i++){
            killRing.add(names.get(i));
        }
    }
    
    //prints remaining players
    public void printKillRing(){
        if(killRing.size() > 1){
            for(int i = 0; i < killRing.size(); i++){
                if(i == killRing.size()-1){
                    System.out.println("  "+killRing.get(i)+" is stalking "+killRing.get(0)); //Tail of kill ring, last player targets first
                } else{
                    System.out.println("  "+killRing.get(i)+" is stalking "+killRing.get(i+1)); //(i)th player targets the next player
                }
            }
        }
    }
    
    //prints killer and victim
    public void printGraveyard(){
        if(!(graveyard.size() < 1)){
            for(int i = graveyard.size()-1; i >= 1; i -= 2){
                if(i < graveyard.size()){
                    System.out.println("  "+graveyard.get(i-1)+" was killed by "+graveyard.get(i));
                }
            }
        }
    }
    
    //checks if someone is still alive
    public boolean killRingContains(String name){
        for(int i = 0; i < killRing.size(); i++){
            if(name.compareToIgnoreCase(killRing.get(i)) == 0){
                return true;
            }
        }
        return false;
    }
    
    //checks if someone is still dead
    public boolean graveyardContains(String name){
        for(int i = 0; i < graveyard.size(); i++){
            if(name.compareToIgnoreCase(graveyard.get(i)) == 0){
                return true;
            }
        }
        return false;
    }
    
    //checks if there is one player left
    public boolean isGameOver(){
        return killRing.size() == 1;
    }
    
    //returns winners name
    public String winner(){
        if(isGameOver()){
            return killRing.get(0);
        }
        return null;
    }
    
    //kills user if they are in the killring
    public void kill(String name){
        if(isGameOver()){
            throw new IllegalStateException("Game is over.");
        } else if(!killRingContains(name) && !graveyardContains(name)){
            throw new IllegalArgumentException("Unknown person.");
        }
        
        if(killRingContains(name)){
            if(killRing.indexOf(name) != 0){
                graveyard.add(killRing.get(killRing.indexOf(name)));
                graveyard.add(killRing.get(killRing.indexOf(name)-1));
            } else{
                graveyard.add(killRing.get(killRing.indexOf(name)));
                graveyard.add(killRing.get(killRing.size()-1));
            }
            killRing.remove(killRing.indexOf(name));
        }
    }
}
