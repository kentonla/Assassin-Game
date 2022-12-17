/**
Assassin Game
By: Kenton La  
*/
import java.util.*;
import java.io.*;

//reads names file
//constructs object for AssassinManager class
//1. Asks user for names of victim
//2. Assassinate victim if possible
//3. Last one standing wins
public class AssassinMain
{
    public static void main(String args[]) throws Exception{
        Scanner names = new Scanner(new File("names.txt"));
        List<String> namesList = new LinkedList<String>();
        while(names.hasNextLine()){
            namesList.add(names.nextLine());
        }
        System.out.println("Game Description:\nThis is \"Assassin\", a game where players are trying to\neliminate their assigned targets without being eliminated themselves.\n\n" +
        "Each player only knows their own target and does not know\nwho is targeting them or who the other players are targeting.\n\n" +
        "The game is played with a group of people,\nand the targets are randomly assigned in a circular chain called the \"kill ring\".\n\n"+ 
        "For example, if there are five players named Isabella, Ray, Norman, Emma, and Phil,\nthe kill ring might be arranged such that Isabella is targeting " + 
        "Ray, Ray is targeting Norman,\nNorman is targeting Emma, Emma is targeting Phil, and Phil is targeting Isabella.\n\n" + 
        "The kill ring is represented as a linked list,\nwith the next person in the list being the target of the current player.\n" + 
        "If a player is killed, they are sent to the graveyard and removed from the kill ring.\n\n");
        AssassinManager manager = new AssassinManager(namesList);
        Scanner input = new Scanner(System.in);
        while(!manager.isGameOver()){
            System.out.println("Current kill ring:");
            manager.printKillRing();
            System.out.println("Current graveyard:");
            manager.printGraveyard();
            
            System.out.print("\nEnter a victim: ");
            String victim = input.nextLine();
            
            if(manager.killRingContains(victim)){
                manager.kill(victim);
            } else if(manager.graveyardContains(victim)){
                System.out.println(victim+" is already dead.");
            } else{
                System.out.println("Unknown person.");
            }
            System.out.println();
        }
        System.out.println("\nGame was won by "+manager.winner());
        System.out.println("\nFinal graveyard is as follows: ");
        manager.printGraveyard();
    }
}
