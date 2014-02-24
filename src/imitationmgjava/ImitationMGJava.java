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
public class ImitationMGJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*default values*/
        int NumberOfIterations = 10000;
        int NumberOfPopulations = 1;
        int NumberOfAgents = 101;
        int NumberOfPlayers = NumberOfAgents;
        int NumberOfImitators = 5;
        int NumberOfRoundsPerImitation = 3;
        
        
        if (args.length > 0) {
            try {
                NumberOfIterations = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + " must be an integer");
                System.exit(1);
            }
            
            
            try {
                NumberOfPopulations = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + " must be an integer");
                System.exit(1);
            }
            
            try {
                NumberOfAgents = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + " must be an integer");
                System.exit(1);
            }
        }
        int Refidx;
        int count=0;
        boolean Minority;
        Initialization Game = new Initialization();
        
        Initialization.InitilizationOfPopulation GamePlayers = Game.new InitilizationOfPopulation();
        
        ArrayList<Population> PopulationList = GamePlayers.InitializePopulations(NumberOfPopulations,NumberOfAgents);
        
        GamePlay GamePlay = new GamePlay();
        Imitation Imitation = new Imitation();
        Random rand = new Random();
        
        ArrayList<ArrayList<Agent>> GameList = GamePlay.CreateGameList(PopulationList, NumberOfPlayers, NumberOfIterations);
        ArrayList<ArrayList<ArrayList<Agent>>> ImitatorsList = 
        Imitation.GenerateImitatorList(PopulationList, NumberOfImitators, NumberOfIterations, NumberOfRoundsPerImitation);
        
        
        if(PopulationList.size() == 1){
            
            for(int i = 0; i < GameList.size(); i++){
                BitSet ActionList = new BitSet(GameList.get(i).size());
                for(int j = 0; j < GameList.get(i).size(); j++){
                  ActionList.set(j, GameList.get(i).get(j).Action); 
                }    
                
                int ActionAggr = ActionList.cardinality();
                if(ActionAggr <= (int)((GameList.get(i).size() - 1) / 2)){
                   Minority = true;   
                }else{
                   Minority = false;
                }
                
                                 
                
                for(int j = 0; j < GameList.get(i).size(); j++){
                    
                    if(GameList.get(i).get(j).Action == Minority){
                        GameList.get(i).get(j).score++;
                    }
                    
                    if( j %  NumberOfRoundsPerImitation == 0){
                        count++;
                        for(int h = 0; h < ImitatorsList.size(); h++){
                            for(int k = 0; k < ImitatorsList.get(h).get((j / count)).size(); k++ ) {
                                Refidx = ImitatorsList.get(h).get((j / count)).get(k).ReferenceAgent;
                                //if(PopulationList.get(h).AgentList.contains(k))
                            }
                         }
                    }
                    
                    double Tempp = rand.nextDouble();
                    if(Tempp < GameList.get(i).get(j).p){
                        GameList.get(i).get(j).Action = true;
                    }else{
                        GameList.get(i).get(j).Action = false;
                    }
                }    
            }            
        }else{
           for(int i = 0; i < GameList.size(); i++){
                for(int j = 0; j < GameList.get(i).size(); j++){
                    
                } 
           }   
        }
        System.out.println();
    }
    
    
}
