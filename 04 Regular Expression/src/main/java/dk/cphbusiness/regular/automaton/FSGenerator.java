package dk.cphbusiness.regular.automaton;

import java.util.ArrayList;

/**
 * 1. (p|q) is a regular expression denoting the set L(p) union L(q), where union denotes the union. 
 * 2. (p)(q) is a regular expression denoting the set of all concatenations of m and n, where m in L(p) and n in L(q). 
 * 3. (p)^* is a regular expression denoting closure of L(p), that is, the set of zero or more concatenations of strings from L(p)
 */
public class FSGenerator {

    String regex;
    ArrayList<String> actions;
    ArrayList<String> possibilities = new ArrayList();
    boolean storeLetters = false;
    IState stateDesc = new StateImpl(0, false);

    private String state = "";
    private String startState = "";
    private String lastState = "";
    private final String falseState = "FALSE_STATE";
    private int actionsIndex = 0;
    boolean loop = false;
    boolean clearPossibilites = false;
    private char previousChar;

    public FSGenerator(String regex, ArrayList<String> actions) {
        this.regex = regex;
        this.actions = actions;
    }

    public void generate() {
        regexParser();
    }

    public void letterHandler(int i, String letter, char focusedChar) {
        if ("".equals(startState)) {
            System.out.println("First Letter " + letter);
            possibilities.add(letter);
            if (!storeLetters) {
                transitionState();
            }
            startState = letter;
        } else {
            if (i + 1 == regex.length()) {
                lastState = letter;
            }
            possibilities.add(letter);

            if (!storeLetters) {
                transitionState();
            }
        }
    }

    public void symbolHandler(String letter) {
        switch (letter) {
            case "(":
//                System.out.print("is (");
                storeLetters = true;
                break;
            case ")":
                storeLetters = false;
                transitionState();
//                System.out.print("is *");
                break;
            case "*":
                loop = true;
                transitionState();
                loop = false;
//                System.out.print("is *");
                possibilities.clear();
                break;
            case "|":
//                System.out.print("is |");
                break;
        }
    }

    public void checkValidState() {
        String isValid;

        if (lastState.equals(state)) {
            isValid = "State is valid";
        } else {
            isValid = "State is not valid";
        }
        System.out.println(isValid);
    }

    public boolean transitionState() {
        String letter = actions.get(actionsIndex);
        boolean match = false;

        for (String possibility : possibilities) {
            if (possibility.equals(letter)) {
                System.out.println("NEW STATE >> " + letter + " : " + stateDesc.symbolToState(IState.Symbol.valueOf(letter)));
                match = true;
                state = letter;
                actionsIndex++;
                break;
            }
        }
        if (match) {
            return true;
        } else if (loop && match) {
            transitionState();
            return true;
        } else if (loop && !match) {
            return false;
        }
        System.out.println("transition false");
        state = falseState;
        return false;
    }

    public void regexParser() {
        for (int i = 0; i < regex.length(); i++) {
            char focusedChar = regex.charAt(i);
            String letter = Character.toString(focusedChar);
            boolean isLetter = Character.isLetter(focusedChar);
            String prevChar = Character.toString(previousChar);
            if (!Character.isLetter(previousChar) && isLetter && ")".equals(prevChar)) {
                possibilities.clear();
            }
            System.out.println("focused: \"" + letter + "\"");
            if (isLetter) {
                letterHandler(i, letter, focusedChar);
            } else {
                symbolHandler(letter);
            }
        }
    }

    public String getState() {
        return state;
    }

    public void isStateFinal() {
        String isFinal;

        if (lastState.equals(state)) {
            isFinal = "State is final";
        } else {
            isFinal = "State is NOT final";
        }
        System.out.println(isFinal);
    }
}
