package dk.cphbusiness.regular.automaton;

import java.util.ArrayList;
import java.util.List;

public class FSAutomatonImpl implements IAutomaton {

    private static ArrayList<Instance> logInstances = new ArrayList();
    ArrayList<String> actions = new ArrayList();

    @Override
    public ArrayList<String> getActions() {
        return actions;
    }

    @Override
    public void setActions(String... a) {
        for (String string : a) {
            this.actions.add(string);
        }
    }

    public ArrayList<Instance> getInstances() {
        return logInstances;
    }

    @Override
    public void addInstance(Instance instance) {
        logInstances.add(instance);
    }

    @Override
    public void addLog(Log log) {
        if (logInstances.size() < 1) {
            Instance logInstance = new Instance(log.getInstance(), "");
            logInstance.addLog(log);
            logInstances.add(logInstance);
        } else {
            for (int i = 0; i < logInstances.size(); i++) {
//                System.out.println("LOG: " + logInstances.get(i).getInstance() + ", " + log.getInstance());
                   if (logInstances.get(i).getInstance() == log.getInstance()) {
                    logInstances.get(i).addLog(log);
                } else {
                    Instance newInstance = new Instance(log.getInstance(), "");
                    newInstance.addLog(log);
                    logInstances.add(newInstance);
                }
                   System.out.println("LOG ENTRY: " + log.toString());
            }

        }
    }
    
  private final IAlphabet alphabet = new AlphabetImpl();
  private final List<IState> states = new ArrayList<>();
  private final IState[][] table;
  private final IState initialState;
  
  public FSAutomatonImpl() {
    states.add(initialState = new StateImpl(0, false));
    for (int index = 1; index < 4; index++) {
      if (index == 3) states.add(new StateImpl(index, true));
      else states.add(new StateImpl(index, false));
      }
    table = new IState[states.size()][alphabet.size()];
    // Actual automaton:
    table[0][0] = states.get(1);
    
    table[1][1] = states.get(1);
    table[1][alphabet.indexOf('c')] = states.get(2);
    table[1][4] = states.get(3);
    
    table[2][3] = states.get(1);
    }

     @Override
  public IAlphabet getAlphabet() { return alphabet; }

  @Override
  public List<IState> getStates() { return states; }

  @Override
  public IState getInitialState() { return initialState; }

  @Override
  public IState nextState(IState state, char symbol) {
    return table[state.getIndex()][alphabet.indexOf(symbol)];
    }

}
