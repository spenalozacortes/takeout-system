import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
  // Instance fields
  private List<Food> menu;

  // Constructor
  public FoodMenu() {
    menu = new ArrayList<>();
    menu.add(new Food("Tacos", "Best", 10));
    menu.add(new Food("Pozole", "Best", 20));
    menu.add(new Food("Enchiladas", "Best", 15));
  }
}