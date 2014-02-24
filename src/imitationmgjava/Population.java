package imitationmgjava;
import java.util.*;
/**
 *
 * @author stathis\
 * The Population Class creates a Population of Agents
 * 
 */
class Population {
     int size; //The number of agents in a Population
     int label; //index label of Population i
     double MixedStrategy; //The strategy of each population 
     ArrayList<Agent> AgentList; //The list of agents in the Population i
     ArrayList<Integer> Scores; // The scores of each agent, brought forth
     BitSet Actions = new BitSet(size); //The actions of agents, brought forth
    
    //Constructor
    Population(int label, int size, double MixedStrategy, ArrayList<Agent> AgentList ){
         
         this.AgentList = new ArrayList<>(AgentList.size()); 
         this.label = label;
         this.size = size;
         this.MixedStrategy = MixedStrategy;
         for(Agent p : AgentList) {
            this.AgentList.add(p.AgentCopy());
            }
         //Collections.copy(this.AgentList, AgentList);
         //this.AgentList = AgentList;
         Scores = new ArrayList<>(); 
         
         for(int i=0; i < size; i++){
            Scores.add(0);
            Actions.set(i, AgentList.get(i).Action);
         }
         
     }
}


