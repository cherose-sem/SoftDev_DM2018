package dk.cphbusiness.regular.automaton;

import java.util.ArrayList;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Instance {

    int instance;
    ArrayList<Log> logs = new ArrayList();
    FSGenerator gen;
    String regex;

    public Instance(int instance) {
        this.instance = instance;
    }

    public Instance(int instance, String regex) {
        this.instance = instance;
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public ArrayList<Log> getLogList() {
        return logs;
    }

    public void setLogList(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }

    public void addLog(Log log) {
        logs.add(log);
    }

    public void processLogs() {
        ArrayList<String> actions = new ArrayList();

        for (Log log : logs) {
            actions.add(log.getAction());
        }

        this.gen = new FSGenerator(regex, actions);
        gen.generate();
    }

    public FSGenerator getGenerator() {
        return this.gen;
    }

    public String getState() {
        return gen.getState();
    }

    public void isStateFinal() {
        gen.isStateFinal();
    }

    public void print() {
        System.out.println("Instance{" + "instance=" + instance + ", regex=" + regex + '}');
//        for (Log log : logs) {
//            System.out.println(log.level + "," + log.system + "," + log.action + "," + log.timestamp );
//        }
    }

}
