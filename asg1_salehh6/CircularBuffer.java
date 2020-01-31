package asg1_salehh6;

public class CircularBuffer {
	private double[] array;
	private int size;
	private int writeIndex;
	
	// Constructor
    public CircularBuffer(int n) {
    	this.array = new double[n];
    	this.size = n;
    	this.writeIndex = 0;
    	for (int i = 0; i < n; i++) {
    		this.array[i] = 0;
    	}
    }
	
	public double getElement(int n) {
		return array[n];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWriteIndex() {
		return writeIndex;
	}

	public void setWriteIndex(int writeIndex) {
		this.writeIndex = writeIndex;
	}
    
	public void add(double value) throws Exception {
		if (writeIndex == size) {
			writeIndex = 0;
		}
		array[writeIndex] = value;
		writeIndex++;
	}
}
