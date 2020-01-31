package asg1_salehh6;
/**
 * Used in Questions 1 and 2
 */
public class Marble {
	public enum Colour {
		WHITE, BLACK, PINK, RED, BLUE
	}
	private String name;
	private Marble.Colour colour;
	private double weight;
	
	// Constructor
	public Marble(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Marble.Colour getColour() {
		return colour;
	}
	public void setColour(Marble.Colour colour) {
		this.colour = colour;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
