package asg1_salehh6;
/**
 * Question 2
 */
public class ArrayMarblesBag {
	Marble[] marbles;
	int currentIndex;
	
	// Constructor
    public ArrayMarblesBag() {
    	this.marbles = new Marble[100];
    	this.currentIndex = 0;
    }
    
    public int getCurrentIndex() {
    	return this.currentIndex;
    }
    
    public void decrementCurrentIndex() {
    	this.currentIndex--;
    }
    
    public void incrementCurrentIndex() {
    	this.currentIndex++;
    }

	public void add(String name) throws Exception {
		if (this.containsName(name)) {
			throw new Exception("The Marble Bag already contains " + name);
		} else if (getCurrentIndex() == 100) {
			throw new Exception("The Marbles bag is full");
		} else {
			marbles[getCurrentIndex()] = new Marble(name);
			incrementCurrentIndex();
		}
	}
	
	public boolean containsName(String name) {
		for (int i = 0; i < getCurrentIndex(); i++) {
			if (marbles[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsColour(Marble.Colour colour) {
		for (int i = 0; i < getCurrentIndex(); i++) {
			if (marbles[i].getColour().equals(colour)) {
				return true;
			}
		}
		return false;
	}
	
	public void del(String name) throws Exception {
		if (!this.containsName(name)) {
			throw new Exception("The Marble Bag doesn't contain Marble with this name");
		} else {
			for (int i = 0; i < getCurrentIndex(); i++) {
				if (marbles[i].getName().equals(name)) {
					for (int j = i; j < getCurrentIndex() - 1; j++) {
						marbles[j] = marbles[j+1];
					}
					decrementCurrentIndex();
					return;
				}
			}
		}
	}
	
	public void delc(Marble.Colour colour) throws Exception {
		if (!this.containsColour(colour)) {
			throw new Exception("The Marble Bag doesn't contain Marble with this colour");
		} else {
			for (int i = 0; i < getCurrentIndex(); i++) {
				if (marbles[i].getColour().equals(colour)) {
					del(marbles[i].getName());
					return;
				}
			}
		}
	}
	
    public boolean isEmpty() {
        return getCurrentIndex() == 0;
    }

    public boolean isEmptyC(Marble.Colour colour) {
		for (int i = 0; i < getCurrentIndex(); i++) {
			if (marbles[i].getColour().equals(colour)) {
				return false;
			}
		}
		return true;
    }
    
    public int size() {
		return getCurrentIndex();
    }
    
    public int sizeC(Marble.Colour colour) {
    	int counter = 0;
		for (int i = 0; i < getCurrentIndex(); i++) {
			if (marbles[i].getColour().equals(colour)) {
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
    		for (int i = 0; i < getCurrentIndex(); i++) {
    			if (marbles[i].getWeight() > max) {
    				max = marbles[i].getWeight();
    			}
    		}
    	}
    	return max;
    }
    
    public double minw() throws Exception{
    	double min = Integer.MIN_VALUE;
    	if (this.isEmpty() == true) {
    		throw new Exception("The Marbles Bag is empty.");
    	} else {
    		for (int i = 0; i < getCurrentIndex(); i++) {
    			if (marbles[i].getWeight() < min) {
    				min = marbles[i].getWeight();
    			}
    		}
    	}
    	return min;
    }
}