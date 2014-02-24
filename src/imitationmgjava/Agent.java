package imitationmgjava;
/**
 *
 * @author stathis
 * This is the Agent Class that creates a single Agent
 * 
 * 
 * 
 */
class Agent {
    int label, plabel, score; //the label, population label, score of agent i
    double p; //Mixed strategy of population
    double Refp;
    boolean  Action, RefAction; //bit defining the action of agent i 
    int ReferenceAgent; //label of referee agent
    
    
    //a default constructor
    Agent(int label, int plabel, int score, double p, boolean action){
        this.label = label;
        this.plabel = plabel;
        this.score = score;
        this.p = p;
        this.Action = action;
        this.RefAction = action;
        this.ReferenceAgent = label;
        this.Refp = p;
    }
    
    
    
    //a more extensive constructor
    Agent(int label, int plabel, int score, double p, boolean action, boolean refaction, double Refp, int refagent){
        this.label = label;
        this.plabel = plabel;
        this.score = score;
        this.p = p;
        this.Action = action;
        this.RefAction = refaction;
        this.Refp = Refp;
        this.ReferenceAgent = refagent;
    }
    
    
    
   //Handy Copy of an agent
   Agent AgentCopy(Agent AgentToCopy){   
         
         Agent NewAgent = new Agent(AgentToCopy.label,AgentToCopy.plabel, 
                                    AgentToCopy.score, AgentToCopy.p, AgentToCopy.Action, 
                                    AgentToCopy.RefAction, AgentToCopy.Refp, AgentToCopy.ReferenceAgent);
         return NewAgent;
    }
    
   //Handy Copy of myself
   Agent AgentCopy(){   
         
         Agent NewAgent = new Agent(this.label,this.plabel, 
                                    this.score, this.p, this.Action, 
                                    this.RefAction, this.Refp, this.ReferenceAgent);
         return NewAgent;
    }
   
}

