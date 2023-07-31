import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int money = 0;

    System.out.println("What's your name?");
    String customerName = input.next();
    System.out.println("How much money do you have?");
    try {
      money = input.nextInt();  
    } catch(InputMismatchException e) {
       System.out.println("That's not a valid input. Try again!");
    }

    Customer customer = new Customer(customerName, money);
    TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, input);

    takeOutSimulator.startTakeOutSimulator();
  }    
}
