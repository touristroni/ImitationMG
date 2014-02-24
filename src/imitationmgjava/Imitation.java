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
public class Imitation {
    
    ArrayList<ArrayList<ArrayList<Agent>>> GenerateImitatorList(ArrayList<Population> PopulationList, 
            int NumberOfImitators, int NumberOfIterations, int NumberOfRoundsPerImitation){
       
        
       int ListSize = NumberOfIterations / NumberOfRoundsPerImitation; 
       Random rand = new Random();
       //ArrayList<ArrayList<Agent>> ImListPerPopul = new ArrayList<>(ListSize);
       ArrayList<ArrayList<ArrayList<Agent>>> ImList = new ArrayList<>(PopulationList.size());
      
     for(int h = 0; h < PopulationList.size(); h++ ){
         
       ArrayList<ArrayList<Agent>> ImListPerPopul = new ArrayList<>(ListSize);  
       for(int i = 0; i < ListSize; i++ ){
           ArrayList<Agent> TurnPlayers = new ArrayList<>(NumberOfImitators);
           for(int j = 0; j < NumberOfImitators; j++ ){
            Agent TempImAgent = PopulationList.get(h).AgentList.get(rand.nextInt(PopulationList.get(h).AgentList.size()));
            TempImAgent.ReferenceAgent = rand.nextInt(PopulationList.get(0).AgentList.size());
            TempImAgent.RefAction = 
                    PopulationList.get(h).AgentList.get(TempImAgent.ReferenceAgent).Action;
            TempImAgent.Refp = 
                    PopulationList.get(h).AgentList.get(TempImAgent.ReferenceAgent).p;
            TurnPlayers.add(TempImAgent);   
           }
           ImListPerPopul.add(TurnPlayers);
       }
       
       ImList.add(ImListPerPopul);
     }
       
     
       return ImList;    
    }
    
    
}
