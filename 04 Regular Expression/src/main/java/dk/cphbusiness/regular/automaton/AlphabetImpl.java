package dk.cphbusiness.regular.automaton;

public class AlphabetImpl implements IAlphabet {
    
  @Override
  public int indexOf(char symbol) {
    if (symbol < 'a' || 'e' < symbol) throw new IllegalArgumentException();
    return symbol - 'a';
    }

  @Override
  public char symbolOf(int index) {
    if (index < 0 || 4 < index) throw new IllegalArgumentException();
    return (char)('a' + index);
    }
  
  @Override
  public int size() { return 5; }
  
  }
