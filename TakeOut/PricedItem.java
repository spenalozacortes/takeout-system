public interface PricedItem<T extends Number> {
 // Abstract methods
 T getPrice();
 void setPrice(T price);
}