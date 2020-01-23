import java.util.Iterator;

public class MarblesBag implements Iterable<Marble> {
	private Node first;

	private class Node {
		Marble item;
		Node next;
	}
	
    public MarblesBag() {
        first = null;
    }

	public void add(String name, String colour, double weight) throws Exception {
		if (this.containsName(name)) {
			throw new Exception("The Marble Bag already contains " + name);
		} else {
			Node oldfirst = first;
			first = new Node();
			first.item = new Marble(name, colour, weight);
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
	
	public boolean containsColour(String colour) {
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
	
	public void delc(String colour) throws Exception {
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

    public boolean isEmptyC(String colour) {
    	//TODO
    }
    
    public int size() {
    	//TODO
    }
    
    public int sizeC(String colour) {
    	//TODO
    }
    
    public int maxw() {
    	//TODO
    }
    
    public int minw() {
    	//TODO
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