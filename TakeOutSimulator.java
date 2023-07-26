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

  public boolean shouldSimulate() {
    String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program: ";

    IntUserInputRetriever<Boolean> userInputRetriever = selection -> {
      if (selection == 1 && customer.getMoney() >= menu.getLowestCostFood().getPrice()) {
        return true;
      } else if (selection == 0) {
        System.out.println("Thank you for eating with us! See you soon!");
        return false;
      } else {
        throw new IllegalArgumentException();
      }
    };

    return this.getOutputOnIntInput(userPrompt, userInputRetriever);
  }

  public Food getMenuSelection() {
    System.out.println("Today's Menu Options!");
    System.out.println(menu);
    String userPrompt = "Your choice (enter the corresponding number): ";

    IntUserInputRetriever<Food> userInputRetriever = selection -> {
      if (menu.getFood(selection) != null) {
        return menu.getFood(selection);
      } else {
        throw new IllegalArgumentException();
      }
    };

    return this.getOutputOnIntInput(userPrompt, userInputRetriever);
  }
}