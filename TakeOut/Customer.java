public class Customer {
  // Instance fields
  private String name;
  private int money;

  // Constructor
  public Customer(String name, int money) {
    this.name = name;
    this.money = money;
  }

  // Getters and setters
  public String getName() {
    return this.name;
  }

  public int getMoney() {
    return this.money;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMoney(int money) {
    this.money = money;
  }
}