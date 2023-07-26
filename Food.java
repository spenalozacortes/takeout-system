public class Food implements PricedItem<Integer> {
  // Instance fields
  private String name;
  private String description;
  private int price;

  // Constructor
  public Food(String name, String description, int price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  // Methods
  @Override
  public Integer getPrice() {
    return this.price;
  }

  @Override
  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Enjoy " + this.name + ": " + this.description + "    Cost: " + this.price;
  }
}