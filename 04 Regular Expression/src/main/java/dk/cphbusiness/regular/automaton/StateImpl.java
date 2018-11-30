package dk.cphbusiness.regular.automaton;

public class StateImpl implements IState {

    private State state = State.IDLE;
    private State startNode = State.IDLE;
    private State endNode = State.LOGOUT;

     public void transitionState(Symbol nextState) {
        boolean allowTransition = verifyTransition(nextState);
        if(allowTransition == true) {
            state = symbolToState(nextState);
        } else {
            state = State.FALSE_STATE; 
       }
    }
        
//    A Login, 100
//    B List items, 50
//    C Edit item, 500
//    D Logout, 200
    public State symbolToState(Symbol sym) {
        switch (sym) {
            case A:
                return State.LOGIN;
            case B:
                return State.LIST_ITEMS;
            case C:
                return State.EDIT_ITEM;
            case D:
                return State.LOGOUT;
            default:
                System.out.println("unknown symbol");;
                return State.FALSE_STATE;
        }
    }
    
//    Example: A(B|C)*D

    private boolean verifyTransition(Symbol symbol) {
        boolean result;
        switch (state) {
            case IDLE:
                result = (symbol == Symbol.A);
                return result;
            case LOGIN:
                result = (symbol == Symbol.B || symbol == Symbol.C || symbol == Symbol.D);
                return result;
            case LIST_ITEMS:
                result = (symbol == Symbol.B || symbol == Symbol.C || symbol == Symbol.D);
                return result;
            case EDIT_ITEM:
                result = (symbol == Symbol.B || symbol == Symbol.C || symbol == Symbol.D);
                return result;
            case LOGOUT:
                result = (symbol == Symbol.A);
                return result;
            default:
                return false;
        }
    }

    private final int index;
    private final boolean isFinal;
    
    public StateImpl(int index, boolean isFinal) {
        this.index = index;
        this.isFinal = isFinal;
    }

    @Override
    public int getIndex() {
        return index;
    }
    
        
    @Override
    public State getState() {
        return state;
    }

    @Override
    public boolean isFinal() {
       return endNode == state;
    }

}
