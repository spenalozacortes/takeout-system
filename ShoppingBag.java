import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
  // Instance fields
  private Map<T, Integer> shoppingBag;

  // Constructor
  public ShoppingBag() {
    shoppingBag = new HashMap<>();
  }

  // Methods
  public void addItem(T item) {
    if (shoppingBag.get(item) == null) {
      shoppingBag.put(item, 1);
    } else {
      shoppingBag.put(item, shoppingBag.get(item) + 1);
    }
  }
}