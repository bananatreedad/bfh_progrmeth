import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;

/**
 * Model the data. 
 * Fields:
 * 
 * - Name; the name of a certain object
 * - Quantity; the quantity of the with name tagged object
 *
 */
public class Model extends Observable {
	private HashMap<String, Integer> data = new HashMap<>();
	
	public Model() {
		data.put("Apfel", 50);
		data.put("Birne", 30);
		data.put("Orange", 40);
	}
	
	public Set<String> getNames() {
		return data.keySet();
	}
	
	public Integer getQuantity(String key) {
		return data.get(key);
	}
	
	public void setQuantity(String key, Integer quantity) {
		data.put(key, quantity);
		
		//both lines are needed to notify properly
		setChanged();
		//add an entry containing the data
		notifyObservers(new AbstractMap.SimpleImmutableEntry<String, Integer>(key, quantity));
	}
}
