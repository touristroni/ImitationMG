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
class GamePlay {
    
  ArrayList<ArrayList<Agent>>  CreateGameList( ArrayList<Population> PopulationList, int NumberOfPlayers, int NumberOfIterations){
      
      ArrayList<ArrayList<Agent>> GameList = new ArrayList<>();
      Random rand = new Random();
      
      
      if(PopulationList.size() == 1){
         if(NumberOfPlayers == PopulationList.get(0).AgentList.size()){ 
            for(int i = 0; i < NumberOfIterations; i++){
              GameList.add(PopulationList.get(0).AgentList);
            }
         }else{
            for(int i = 0; i < NumberOfIterations; i++){
              
              Collections.shuffle(PopulationList.get(0).AgentList);
              ArrayList<Agent> TurnPlayers;
              TurnPlayers = new ArrayList<>(PopulationList.get(0).AgentList.subList(0, (NumberOfPlayers - 1)));
              GameList.add(TurnPlayers);  
                
            } 
         }
      }else{
          for(int i = 0; i < NumberOfIterations; i++){
              ArrayList<Agent> TurnPlayers = new ArrayList<>(PopulationList.size());
              
              for(int j = 0; j < PopulationList.size(); j++){
                  TurnPlayers.add(PopulationList.get(j).
                 AgentList.get(rand.nextInt(PopulationList.get(0).AgentList.size())));    
              }
              GameList.add(TurnPlayers);
          }
          
      }
      
      return GameList;
  }
    
  
  
  
  
}
