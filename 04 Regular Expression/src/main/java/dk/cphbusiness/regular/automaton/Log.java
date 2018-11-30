
package dk.cphbusiness.regular.automaton;

import java.util.Date;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Log {
     String level;
    int system;
    int instance;
    String action;
    Date timestamp;

    public Log(String level, int system, int instance, String action) {
        this.level = level;
        this.system = system;
        this.instance = instance;
        this.action = action;
        this.timestamp = new Date();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Log{" + "level=" + level + ", system=" + system + ", instance=" + instance + ", action=" + action + ", timestamp=" + timestamp + '}';
    }
    
    
    
}
