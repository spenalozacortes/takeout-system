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

  public boolean isStillOrderingFood() {
    String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT: ";

    IntUserInputRetriever<Boolean> userInputRetriever = selection -> {
      if (selection == 1) {
        return true;
      } else if (selection == 0) {
        return false;
      } else {
        throw new IllegalArgumentException();
      }
    };

    return this.getOutputOnIntInput(userPrompt, userInputRetriever);
  }

  public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
    System.out.println("Processing payment...");
    int remainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();
    customer.setMoney(remainingMoney);
    System.out.println("Your remaining money: " + remainingMoney);
    System.out.println("Thank you and enjoy your food!");
  }

  public void takeOutPrompt() {
    ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
    int customerMoneyLeft = customer.getMoney();
    boolean stillOrdering = true;

    while(stillOrdering) {
      System.out.println("You have " + customerMoneyLeft + " left to spend");
      Food food = this.getMenuSelection();
      if (customerMoneyLeft >= food.getPrice()) {
        customerMoneyLeft -= food.getPrice();
        shoppingBag.addItem(food);
      } else {
        System.out.println("Oops! Looks like you don't have enough for that. Choose another item or checkout.");
      }
      stillOrdering = this.isStillOrderingFood();
      if (stillOrdering == false) {
        this.checkoutCustomer(shoppingBag);
      }
    }
  }

  public void startTakeOutSimulator() {
    boolean simulate = true;

    System.out.println("Hello " + customer.getName() + ", welcome to my restaurant!");
    while(simulate) {
      this.takeOutPrompt();
      simulate = this.shouldSimulate();
    }
  }
}