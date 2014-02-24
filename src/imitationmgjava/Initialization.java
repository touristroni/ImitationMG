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

class Initialization{

class InitializationOfAgents {
    
    
 ArrayList<Agent> InitializeAgents(int NumberOfPopulations, int NumberOfAgents, double Tempp){
    
    ArrayList<Agent> AgentList = new ArrayList<>();
    Random rand = new Random();
    
    if ( NumberOfPopulations == 1){ 
           
        for(int j = 0; j < NumberOfAgents; j++){

            Tempp = rand.nextDouble();
            double TempDraw = rand.nextDouble();
            boolean TempAction ;
            if(TempDraw < Tempp){
                TempAction = true;
            }else{
                TempAction = false;
            }
            Agent TempAgent = new Agent(j, 0, 0, Tempp, TempAction);
            AgentList.add(TempAgent);
         }
    }else{
        
        for(int j = 0; j < NumberOfAgents; j++){

            double TempDraw = rand.nextDouble();
            boolean TempAction ;
            if(TempDraw < Tempp){
                TempAction = true;
            }else{
                TempAction = false;
            }
            Agent TempAgent = new Agent(j, 0, 0, Tempp, TempAction);
            AgentList.add(TempAgent);
         }
        
    }
    
    return AgentList;
}

    
}

class InitilizationOfPopulation {

               
       
       ArrayList<Population> InitializePopulations(int NumberOfPopulations, int NumberOfAgents){
           
           InitializationOfAgents Agents = new InitializationOfAgents(); 
           Random rand = new Random();
           ArrayList<Population> PopulationList = new ArrayList<>();

           for(int i = 0; i < NumberOfPopulations; i++){
               
            double Tempp = rand.nextDouble();
            Population TempPopulation = new Population(i, NumberOfAgents, Tempp, 
            Agents.InitializeAgents(NumberOfPopulations, NumberOfAgents, Tempp));
            PopulationList.add(TempPopulation);

           
           }

           return PopulationList;

      }
       
    }
}