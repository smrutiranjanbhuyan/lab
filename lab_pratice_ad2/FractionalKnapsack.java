package lab_pratice_ad2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    double value;
    double weight;

    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

	public static double getMaxValue(List<Item> items, double capacity) {
	    Collections.sort(items, Comparator.comparingDouble((Item item) -> item.value / item.weight).reversed());

	    double totalValue = 0;
	    for (Item item : items) {
	        if (capacity <= 0) {
	            break;
	        }
	        double fraction = Math.min(1, capacity / item.weight);
	        totalValue += fraction * item.value;
	        capacity -= fraction * item.weight;
	    }
	    return totalValue;
	}

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));
        items.add(new Item(100, 20));
        items.add(new Item(120, 30));

        double capacity = 50;
        double maxValue = getMaxValue(items, capacity);

        System.out.println("Maximum value that can be obtained = " + maxValue);
    }
}
