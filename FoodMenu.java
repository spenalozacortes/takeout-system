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

  // Methods
  @Override
  public String toString() {
    String srt = "";
    for (int i = 0; i < menu.size(); i++) {
      srt += i+1 + ". " + menu.get(i).toString() + "\n";
    }
    return srt;
  }

  public Food getFood(int index) {
    try {
      return menu.get(index - 1);
    } catch(IndexOutOfBoundsException e) {
      return null;
    }
  }
}