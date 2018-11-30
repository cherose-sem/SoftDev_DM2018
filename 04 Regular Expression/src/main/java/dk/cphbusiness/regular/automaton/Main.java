package dk.cphbusiness.regular.automaton;

import dk.cphbusiness.regular.automaton.IState.State;

/*
1
Create a dynamic analyser
Create a Finite State Automaton, that can handle log entries from a running
application (system). The automaton should be able hold states for a number
of running instances (Use case scenarios). The automation should be able to
monitor the following
• is the action legal according to the present state.
• is any instance stuck at a non-final (non-accepting) state.
• give a list of the running instances.

2
Create a Finite State Generator
Create an application that can create a Finite State Automaton to use in
the analyser 1. The generator should take regular expression, and a list of
actions (the alphabet) with max times as input.
Example: A(B|C)*D
A Login, 100
B List items, 50
C Edit item, 500
D Logout, 200
 */
public class Main {

    public static void main(String... args) {

        System.out.println("\n\n FINITE STATE GENERATOR");
        IAutomaton automaton = new FSAutomatonImpl();
        automaton.setActions("A", "B", "C", "D");

        System.out.println("******** \"A(B|C)*D\" ********");
        FSGenerator gen = new FSGenerator("A(B|C)*D", automaton.getActions());
        gen.generate();
        gen.isStateFinal();

        System.out.println("\n\n******** \"AB\" ********");
        automaton.setActions("A", "B");
        FSGenerator gen1 = new FSGenerator("AB", automaton.getActions());
        gen1.generate();
        gen1.isStateFinal();

        System.out.println("\n\n******** \"E\" - Invalid Symbol/Action ********");
        FSGenerator gen2 = new FSGenerator("E", automaton.getActions());
        gen2.generate();
        gen2.isStateFinal();
        
        System.out.println("\n\n******** \"D\" - action: logout only ********");
        FSGenerator gen3 = new FSGenerator("D", automaton.getActions());
        gen3.generate();
        gen3.isStateFinal();

        System.out.println("\n\n******** USING LOGS INSTANCES ********");
        Instance instance = new Instance(1, "A(B|C)*D");

        automaton.addInstance(instance);

        Log log = new Log("INFORMATION", 1, 1, "A");
        automaton.addLog(log);
        Log log1 = new Log("INFORMATION", 1, 1, "B");
        automaton.addLog(log1);
        Log log2 = new Log("WARNING", 1, 1, "C");
        automaton.addLog(log2);
        Log log3 = new Log("ERROR", 1, 1, "D");
        automaton.addLog(log3);

        System.out.println("_____________________________________");
        instance.print();
        instance.processLogs();
        instance.isStateFinal();

//        System.out.println("\n\n******** DEMO ********");
//        String word = "abcd";
//        IState state = automaton.getInitialState();
//        System.out.println("state: " + state.getState());
//
//        for (char symbol : word.toCharArray()) {
//            if (state == null) {
//                System.out.println(word + " does not match");
//            }
//            state = automaton.nextState(state, symbol);
//            System.out.println("State" + state.getState());
//        }
//        if (state == null) {
//            System.out.println(word + " does not match");
//        } else if (state.isFinal()) {
//            System.out.println("You had a match");
//        } else {
//            System.out.println("Partially match");
//        }

    }
}
