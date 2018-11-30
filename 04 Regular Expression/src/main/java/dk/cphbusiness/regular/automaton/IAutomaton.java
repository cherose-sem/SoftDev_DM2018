package dk.cphbusiness.regular.automaton;

import java.util.ArrayList;
import java.util.List;

public interface IAutomaton {
//  IAlphabet getAlphabet();
//  List<IState> getStates();
//  IState getInitialState();
//  // Dependent of impl.
//  // Set<State> getFinalStates();
//  IState nextState(IState state, char symbol);
    
    void addInstance(Instance instance);
    void addLog(Log log);
    ArrayList<String> getActions();
    void setActions(String ...actions);
  }
