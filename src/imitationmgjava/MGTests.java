/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imitationmgjava;
import java.util.*;


/**
 *
 * @author stathis
 */
public class MGTests {
    
    public static void main(String[] args) {
        
        
        int NumberOfPopulations = 5;
        int NumberOfAgents = 10;
        
        Initialization Game = new Initialization();
        
        Initialization.InitilizationOfPopulation GamePlayers = Game.new InitilizationOfPopulation();
      
      /*for(int i = 0; i < NumberOfPopulations; i++){
             System.out.print(PopulationList.get(i).MixedStrategy);
             System.out.print("   ");
             for(int j = 0; j < NumberOfAgents; j++){
                 System.out.print(PopulationList.get(i).AgentList.get(j).Action);
                 System.out.print("   ");
             }
             System.out.println();
          }*/
      
  ;
        
    }
    
}
