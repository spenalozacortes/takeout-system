import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
  // Instance fields
  private Map<T, Integer> shoppingBag;

  // Constructor
  public ShoppingBag() {
    shoppingBag = new HashMap<>();
  }
}