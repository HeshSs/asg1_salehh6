import java.util.ArrayList;
import java.util.Arrays;

public class Marble {
	String[] array = {"white", "black", "pink", "red", "blue"};
	public ArrayList<String> colours = (ArrayList<String>) Arrays.asList(array);
	private String name;
	private String colour;
	private double weight;
	
	public Marble(String name, String colour, double weight) throws Exception {
		if (colours.contains(colour.toLowerCase())) {
			this.name = name;
			this.colour = colour;
			this.weight = weight;
		} else {
			throw new Exception("Valid colours are white, black, pink, red or blue");
		}
	}
	
	public Marble(String name, double weight) {
		this.name = name;
		//a random colour will be chosen
		int random = (int) (Math.random()*5);
		this.colour = colours.get(random);
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
