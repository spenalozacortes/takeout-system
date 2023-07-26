public interface IntUserInputRetriever<T> {
  // Abstract method
  T produceOutputOnIntUserInput(int selection) throws IllegalArgumentException;
}