package asg1_salehh6;
import java.util.Iterator;

/**
 * Question 1
 */
public class MarblesBag implements Iterable<Marble> {
	private Node first;

	private class Node {
		Marble item;
		Node next;
	}
	
	// Constructor
    public MarblesBag() {
        first = null;
    }

	public void add(String name) throws Exception {
		if (this.containsName(name)) {
			throw new Exception("The Marble Bag already contains " + name);
		} else {
			Node oldfirst = first;
			first = new Node();
			first.item = new Marble(name);
			first.next = oldfirst;
		}
	}
	
	public boolean containsName(String name) {
		for (Marble marble : this) {
			if (marble.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsColour(Marble.Colour colour) {
		for (Marble marble : this) {
			if (marble.getColour().equals(colour)) {
				return true;
			}
		}
		return false;
	}
	
	public void del(String name) throws Exception {
		if (!this.containsName(name)) {
			throw new Exception("The Marble Bag doesn't contain Marble with this name");
		} else {
			Iterator<Marble> marbles = this.iterator();
			Marble currentMarble = this.first.item;
			while (marbles.hasNext()) {
				if (currentMarble.getName().equals(name)) {
					marbles.remove();
				} else {
					currentMarble = marbles.next();
				}
			}
		}
	}
	
	public void delc(Marble.Colour colour) throws Exception {
		if (!this.containsColour(colour)) {
			throw new Exception("The Marble Bag doesn't contain Marble with this colour");
		} else {
			Iterator<Marble> marbles = this.iterator();
			Marble currentMarble = this.first.item;
			while (marbles.hasNext()) {
				if (currentMarble.getColour().equals(colour)) {
					marbles.remove();
				} else {
					currentMarble = marbles.next();
				}
			}
		}
	}
	
	
    public boolean isEmpty() {
        return first == null;
    }

    public boolean isEmptyC(Marble.Colour colour) {
		for (Marble marble : this) {
			if (marble.getColour().equals(colour)) {
				return false;
			}
		}
		return true;
    }
    
    public int size() {
    	int counter = 0;
		for (Marble marble : this) {
			counter ++;
		}
		return counter;
    }
    
    public int sizeC(Marble.Colour colour) {
    	int counter = 0;
		for (Marble marble : this) {
			if (marble.getColour().equals(colour)) {
				counter++;
			}
		}
		return counter;
    }
    
    public double maxw() throws Exception {
    	double max = Integer.MIN_VALUE;
    	if (this.isEmpty() == true) {
    		throw new Exception("The Marbles Bag is empty.");
    	} else {
    		for (Marble marble : this) {
    			if (marble.getWeight() > max) {
    				max = marble.getWeight();
    			}
    		}
    	}
    	return max;
    }
    
    public double minw() throws Exception {
    	double min = Integer.MIN_VALUE;
    	if (this.isEmpty() == true) {
    		throw new Exception("The Marbles Bag is empty.");
    	} else {
    		for (Marble marble : this) {
    			if (marble.getWeight() < min) {
    				min = marble.getWeight();
    			}
    		}
    	}
    	return min;
    }
    
	public Iterator<Marble> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Marble> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			current = current.next;
		}

		public Marble next() {
			Marble item = current.item;
			current = current.next;
			return item;
		}
	}
}