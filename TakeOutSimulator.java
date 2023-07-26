import java.util.Scanner;

public class TakeOutSimulator {
  // Instance fields
  private Customer customer;
  private FoodMenu menu;
  private Scanner input;

  // Constructor
  public TakeOutSimulator(Customer customer, Scanner input) {
    this.menu = new FoodMenu();
    this.customer = customer;
    this.input = input;
  }

  // Methods
  private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
    while(true) {
      System.out.println(userInputPrompt);
      if (input.hasNextInt()) {
        int userInput = input.nextInt();
        try {
          return intUserInputRetriever.produceOutputOnIntUserInput(userInput);
        } catch(IllegalArgumentException e) {
          System.out.println(userInput + " is not a valid input. Try Again!");
        }
      } else {
        System.out.println("Input needs to be an `int` type.");
        input.next();
      }
    }
  }
}