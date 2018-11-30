package dk.cphbusiness.regular.automaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

}
