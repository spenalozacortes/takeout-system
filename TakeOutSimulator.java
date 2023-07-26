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
}