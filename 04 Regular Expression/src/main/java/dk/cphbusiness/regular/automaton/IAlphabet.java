package dk.cphbusiness.regular.automaton;

public interface IAlphabet {
  int indexOf(char symbol);
  char symbolOf(int index);
  int size();
  }
